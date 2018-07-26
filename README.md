# Android MVVM

View <=> ViewModel <=> Model

## Key Characteristics

- many Views listen to one ViewModel
- loose coupling between View and ViewModel
- ViewModel doesn't care who is listening
- Android LiveData helps with this

## View

- very light (No logic here)
- informs VM about user actions
- has reference to ViewModel
- consumes data from ViewModel
- it observes the ViewModel for changes in data to present

## ViewModel

- exposes stream of data to the View
- uses Model to get/save data
- has no reference to the View
- broadcasts data and doesn't care who listens

## Model

- abstracts data source
