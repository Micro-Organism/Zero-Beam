package com.zero.apache.beam.controller;

import com.zero.apache.beam.service.BeamService;
import org.apache.beam.sdk.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeamController {

    private final BeamService beamService;
    @Autowired
    public BeamController(BeamService beamService) {
        this.beamService = beamService;
    }

    @GetMapping("/runPipeline")
    public String runPipeline() {
        Pipeline pipeline = Pipeline.create();
        beamService.runPipeline(pipeline);
        return "Pipeline executed successfully";
    }

}
