# What is this
This Java library offers assertions to unit test your GitLab CI configuration. Unit testing your GitLab CI configuration has the following advantages:

- Avoid regression
- Quick feedback loop without breaking the rest of the pipeline
- Run tests as part of the merge request

This allows you to write tests so you don't have to merge changes only to find that you've broken the build.
# API
## GitlabCiAssert.assertAllStagesKnown
This assertion checks that all stages used by the jobs are known:

``` 
GitlabCiAssert.assertAllStagesKnown(GitlabPipelineFileReader.pipelineInProject());
```

## GitlabCiAssert.assertJobsRunsExactly 
This assertion checks that a set of jobs will run, given a set of variables. The variables are optional.

``` 
GitlabCiAssert.assertJobsRunsExactly(GitlabPipelineFileReader.pipelineInProject(), Set.of("build-job", "test-job2", "deploy-prod",
                "test-job1"));
```

To check if specific jobs run when a specific variable is set, you can use:

``` 
GitlabCiAssert.assertJobsRunsExactly(GitlabPipelineFileReader.pipelineInProject(), Set.of("build-job", "test-job2", "deploy-prod",
                "test-job1"));
```

## GitlabCiAssert.assertNeeds
This assertion checks that all needs are met. i.e., every job that has a need has this need met, given it was
resolved in a previous or the current stage (or it's in a default state).

``` 
GitlabCiAssert.assertNeeds(GitlabPipelineFileReader.pipelineInProject());
```

## GitlabCiAssert.assertContainsJobs
This assertion checks that a set of jobs will run, given a set of variables. The variables are optional.

``` 
GitlabCiAssert.assertContainsJobs(GitlabPipelineFileReader.pipelineInProject(), Set<String> expectedJobs, Variable... variables);
```

## GitlabCiAssert.assertJobsNotRun
This assertion checks that a set of jobs will NOT run, given a set of variables. The variables are optional.

``` 
GitlabCiAssert.assertJobsNotRun(GitlabPipelineFileReader.pipelineInProject(), Set<String> expectedJobs, Variable... variables);
```


## Useful functions
A list of predefined variables is available in ```info.thelaboflieven.gitlabci.model.PredefinedVariables```. 

If, for whatever reason, your GitLab pipeline is defined in a different location, you can use:

````
new GitlabPipelineFileReader().read(File file)
````

## Limitations
The gitlab ci specification is huge.
This tool loads only a small set of the gitlab ci specification.

The following are supported:
- Loading job, rules, if conditions, when clauses.
- Loading the job script, no support to run them.
- Loading other local .yml files. 
