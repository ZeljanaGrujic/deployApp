package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.JobTitleDto;

import java.util.List;

public interface JobTitleService {
    List<JobTitleDto> getJobTitles();

    JobTitleDto saveJobTitle(JobTitleDto jobTitle);

    JobTitleDto findById(int id);

    void deleteById(int id);
}
