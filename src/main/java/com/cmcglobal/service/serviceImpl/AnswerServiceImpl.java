package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Answer;
import com.cmcglobal.repository.AnswerRepository;
import com.cmcglobal.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	public List<Answer> getAllAnswer() {
		// TODO Auto-generated method stub
		/**
		 * <p>Java class for country complex type.
		 *
		 * <p>The following schema fragment specifies the expected content contained within this class.
		 *
		 * <pre>
		 * &lt;complexType name="country"&gt;
		 *   &lt;complexContent&gt;
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
		 *       &lt;sequence&gt;
		 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
		 *         &lt;element name="capital" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="currency" type="{http://www.baeldung.com/springsoap/gen}currency"/&gt;
		 *       &lt;/sequence&gt;
		 *     &lt;/restriction&gt;
		 *   &lt;/complexContent&gt;
		 * &lt;/complexType&gt;
		 * </pre>
		 *
		 *
		 */
		return answerRepository.findAll();
	}

	@Override
	public Answer findById(String id) {
		// TODO Auto-generated method stub
		return answerRepository.findById(id).get();
	}

	@Override
	public void insertAnswer(Answer answer) {
		answerRepository.save(answer);
		// abc
	}

	@Override
	public void deletebyId(String id) {	
		answerRepository.deleteById(id);
	}

	@Override
	public String editAnswer(String id, Answer newAnswer) {
		Boolean existA = answerRepository.existsById(id);
		if(!existA) {
			return "No question with id above";
		} else {
			newAnswer.setAnswerId(id);
			answerRepository.saveAndFlush(newAnswer);
			return "Update success";
		}
	}

}
