package com.nutritech.nu34life.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nutritech.nu34life.model.entity.*;
import com.nutritech.nu34life.service.*;
import com.nutritech.nu34life.util.HttpSessionUtil;

@RestController
@RequestMapping("/status")
public class StateController {

	@Autowired
	StateService stateService;
	@Autowired
	GoalService goalService;
	@Autowired
	PhysicalActivityService activityService;
	@Autowired
	MedicalConditionService conditionService;
	@Autowired
	DrugService drugService;
	
	@GetMapping
	public ResponseEntity<PatientState> findPatientState(@RequestParam Long id){
		PatientState result = stateService.findPatientLastState(id).orElse(null);
		if (result == null) {
			return new ResponseEntity<PatientState>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PatientState>(result, HttpStatus.OK);
	}
	
	@GetMapping("/history/{id}")
	public List<PatientState> getPatientStatusHistory(@PathVariable Long id){
		List<PatientState> result = stateService.findPatientHistory(id);
		
		return result;
	}
	
    @PostMapping
    public ResponseEntity<PatientState> createPatientState(@RequestBody PatientState state, @RequestHeader Long id){
    	HttpSessionUtil.getSession().setAttribute("userId", id);
    	
    	System.out.println("DESERIALIZATION COMPLETE");
    	
    	state.setId(null);
    	state.setCreatedDate(null);
    	state.setCreatedBy(null);
    	
    	PatientState result = stateService.save(state);
    	
        return new ResponseEntity<PatientState>(result, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PatientState> editPatientState(@RequestBody PatientState state, @RequestHeader Long id){
    	
    	HttpSessionUtil.getSession().setAttribute("userId", id);
    	
    	PatientState result = stateService.save(state);
    	return new ResponseEntity<PatientState>(result, HttpStatus.CREATED);

    }

    //FIXME: own module?
    
    @GetMapping("/goals")
    public List<Goal> listGoals(){
    	return goalService.findAll();
    }

    @GetMapping("/drugs")
    public List<Drug> listDrugs(){
        return drugService.findAll();
    }

    @GetMapping("/conditions")
    public List<MedicalCondition> listMedicalConditions(){
        return conditionService.findAll();
    }

    @GetMapping("/activities")
    public List<PhysicalActivity> listPhysicalActivities(){
    	return activityService.findAll();
    }

}
