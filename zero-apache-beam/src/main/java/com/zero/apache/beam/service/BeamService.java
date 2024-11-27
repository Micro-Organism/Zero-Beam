package com.zero.apache.beam.service;

import org.apache.beam.sdk.Pipeline;

public interface BeamService {
    void runPipeline(Pipeline pipeline);
}
