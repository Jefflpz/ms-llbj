package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.QuizOptionDTO;
import com.example.ms_llbj.dto.request.QuizQuestionDTO;
import com.example.ms_llbj.dto.request.QuizRequestDTO;
import com.example.ms_llbj.dto.response.QuizResponseDTO;
import com.example.ms_llbj.persistence.entity.*;
import com.example.ms_llbj.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository repository;
    private final SubjectRepository subjectRepository;
    private final AgendaRepository agendaRepository;
    private final MaterialRepository materialRepository;

    public QuizResponseDTO create(QuizRequestDTO dto) {
        Quiz quiz = new Quiz();
        mapToEntity(dto, quiz);
        quiz.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(quiz));
    }

    public List<QuizResponseDTO> findAll(Long subjectId) {
        if (subjectId != null) {
            return repository.findBySubjectId(subjectId).stream().map(this::toResponse).toList();
        }
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public QuizResponseDTO findById(String id) {
        return repository.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));
    }

    public QuizResponseDTO update(String id, QuizRequestDTO dto) {
        Quiz quiz = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));

        // Clear old questions
        quiz.getQuestions().clear();
        mapToEntity(dto, quiz);

        return toResponse(repository.save(quiz));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void mapToEntity(QuizRequestDTO dto, Quiz quiz) {
        quiz.setTitle(dto.getTitle());
        quiz.setDescription(dto.getDescription());
        quiz.setScore(dto.getScore());
        quiz.setReleaseDate(dto.getReleaseDate());
        quiz.setDeadline(dto.getDeadline());

        if (dto.getSubjectId() != null) {
            quiz.setSubject(subjectRepository.findById(dto.getSubjectId()).orElse(null));
        }
        if (dto.getWeekId() != null) {
            quiz.setAgenda(agendaRepository.findById(dto.getWeekId()).orElse(null));
        }
        if (dto.getMaterialId() != null) {
            quiz.setMaterial(materialRepository.findById(dto.getMaterialId()).orElse(null));
        }

        if (dto.getQuestions() != null) {
            for (QuizQuestionDTO qDto : dto.getQuestions()) {
                QuizQuestion question = new QuizQuestion();
                question.setTitle(qDto.getTitle());
                question.setQuiz(quiz);

                if (qDto.getOptions() != null) {
                    for (QuizOptionDTO oDto : qDto.getOptions()) {
                        QuizOption option = new QuizOption();
                        option.setText(oDto.getText());
                        option.setIsCorrect(oDto.getIsCorrect());
                        option.setQuestion(question);
                        question.getOptions().add(option);
                    }
                }
                quiz.getQuestions().add(question);
            }
        }
    }

    private QuizResponseDTO toResponse(Quiz q) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(q.getId());
        dto.setTitle(q.getTitle());
        dto.setDescription(q.getDescription());
        dto.setScore(q.getScore());
        dto.setReleaseDate(q.getReleaseDate());
        dto.setDeadline(q.getDeadline());
        dto.setSubjectId(q.getSubject() != null ? q.getSubject().getId() : null);
        dto.setWeekId(q.getAgenda() != null ? q.getAgenda().getId() : null);
        dto.setMaterialId(q.getMaterial() != null ? q.getMaterial().getId() : null);
        if (q.getCreatedAt() != null)
            dto.setCreatedAt(q.getCreatedAt().toString());

        List<QuizQuestionDTO> questions = q.getQuestions().stream().map(question -> {
            QuizQuestionDTO qDto = new QuizQuestionDTO();
            qDto.setId(question.getId());
            qDto.setTitle(question.getTitle());
            qDto.setOptions(question.getOptions().stream().map(opt -> {
                QuizOptionDTO optDto = new QuizOptionDTO();
                optDto.setId(opt.getId());
                optDto.setText(opt.getText());
                optDto.setIsCorrect(opt.getIsCorrect());
                return optDto;
            }).collect(Collectors.toList()));
            return qDto;
        }).collect(Collectors.toList());

        dto.setQuestions(questions);
        return dto;
    }
}
