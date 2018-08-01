package com.luchoc.mvvmspike.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.luchoc.mvvmspike.service.model.Project;
import com.luchoc.mvvmspike.service.repository.ProjectRepository;

import java.util.List;

// Consumes service API "getProjectList()"
// In charge of making additional modifications (transformations) to the LiveData results
// Exposes LiveData (after massaging) to the View to subscribe and render

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    // constructor
    public ProjectListViewModel(Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        // Retrieves LiveData stream from the Model
        // Information about the transformation class => https://developer.android.com/topic/libraries/architecture/livedata#transformations_of_livedata
        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");
    }

    /**
     * Expose the LiveData Projects query so the View (UI) can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
