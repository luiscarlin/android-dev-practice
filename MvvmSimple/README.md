# MVVM Simple

View <=> ViewModel <=> Model

## Key Characteristics

- many Views listen to one ViewModel
- loose coupling between View and ViewModel
- ViewModel doesn't care who is listening
- Android LiveData helps with this

## View

- very light (no logic here)
- informs ViewModel about ui changes
- is subscribed to ViewModel and consumes data from it to update ui

## ViewModel

- exposes stream of data through observables
- uses Model to get/update data
- has no reference to the View
- broadcasts data and doesn't care who listens

## Model

- in charge of data and business logic
- expose data through observables
