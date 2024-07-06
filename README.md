# What is this
This library offers you assertions to unit test your gitlab ci configuration.
Unit testing your gitlab ci configuration has the following advantages:
- Avoid regression
- Quick feedback loop without breaking the rest of the pipeline. 
- Run tests in as part of the merge request. 

This allows you to write tests so you don't have to merge things, only to see that you've broken the build. 

# API
## GitlabCiAssert.assertAllStagesKnown
This assertion checks that all stages, as used by the jobs, are known:
``` 
GitlabCiAssert.assertAllStagesKnown(GitlabPipelineFileReader.pipelineInProject());
```

## GitlabCiAssert.assertJobsRun 
This assertion checks that a set of jobs will run, given a set of variables. 
The variables are optional.

``` 
GitlabCiAssert.assertJobsRun(GitlabPipelineFileReader.pipelineInProject(), Set.of("build-job", "test-job2", "deploy-prod",
                "test-job1"));
```

To check specific jobs run if a specific variable is set you can use: 
``` 
GitlabCiAssert.assertJobsRun(GitlabPipelineFileReader.pipelineInProject(), Set.of("build-job", "test-job2", "deploy-prod",
                "test-job1"));
```

## GitlabCiAssert.assertNeeds
This assertions that all needs are met. i.e. Every job that has a need, has this need met given it was 
resolved in a previous or the current stage. 

``` 
GitlabCiAssert.assertNeeds(GitlabPipelineFileReader.pipelineInProject());
```


## Useful functions
A list of predefined variables are available in ```info.thelaboflieven.gitlabci.model.PredefinedVariables```. 

If for whatever reason you your gitlab pipeline defined in a different location you can use: 

````
new GitlabPipelineFileReader().read(File file)
````