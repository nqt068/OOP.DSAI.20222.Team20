
# Sorting Algorithms Visualizer

This is a Java project developed for the Object-Oriented Programming course. The project aims to provide users with a tool to visualize how sorting algorithms work on arrays.

## Table of contents
- [Team Members](#team-members)
- [Description](#description)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Task Distribution](#task-distribution)
- [Demo Video](#demo-video)


## Team Members
#### Nguyen Thi Trang - 20194458
#### Tran Van Toan - 20214932
#### Nguyen Quang Tri - 20210860
#### Dang Kieu Trinh - 20214933


## Description

The Sorting Algorithm Visualizer is designed to help users understand the inner workings of sorting algorithms by providing a visual representation of the sorting process. Users can input an array of numbers, select a sorting algorithm, and observe the step-by-step execution of the algorithm on the array.

## Project Structure

The project repository consists of the following folders:

- **design**: Contains design diagrams, including the general class diagram, use case diagram, and other package class diagrams.
- **Image_resources**: Contains image resources used in the application, such as icons and images.
- **demo**: Contains a demo video showcasing the functionality of the Sorting Algorithm Visualization Tool.
- **presentation**: Contains the pptx file for the presentation.
- **report**: Contains the report paper for the project.
- **sourcecode**: Contains the source code files of the Sorting Algorithm Visualizer.

## Installation
To use the Sorting Algorithm Visualizer, you need to clone the project repository from GitHub:

``` git clone https://github.com/nqt068/OOP.DSAI.20222.Team20.git ```

## Usage

To run the Sorting Algorithm Visualizer, follow these steps:

1. Open the `App.java` file located in the `sourcecode` folder.
2. The application will start, and you will be presented with a user interface on the home screen where you can select a sorting algorithm.
3. Once you have selected a sorting algorithm, the sorting screen will appear.
4. You have two options for inputting an array:
   - Manually input an array by entering values in the provided input fields.
   - Generate a random array by clicking the "Create (A)" button.
5. After inputting the array, click the "Sort" button to start the visualization.

## Task Distribution

| Task                               | Role                                   | Member                                               |
|------------------------------------|----------------------------------------|------------------------------------------------------|
| algorithm                          | SortingAlgorithm.java                  | Nguyen Quang Tri                                     |
|                                    | ShellSortAlgorithm.java                | Tran Van Toan                                       |
|                                    | SelectionSortAlgorithm.java            | Dang Kieu Trinh                                     |
|                                    | MergeSortAlgorithm.java                | Nguyen Thi Trang                                    |
| component                          | ArrayGraphic.java                      | Nguyen Quang Tri                                     |
|                                    | ButtonComponent.java                   | Nguyen Quang Tri, Dang Kieu Trinh, Tran Van Toan     |
|                                    | CardComponent.java                     | Nguyen Quang Tri, Dang Kieu Trinh                    |
|                                    | InfoWindowComponent.java               | Nguyen Quang Tri, Nguyen Thi Trang, Dang Kieu Trinh  |
|                                    | LabelComponent.java                    | Nguyen Quang Tri, Nguyen Thi Trang                   |
|                                    | SliderBarComponent.java                | Nguyen Quang Tri                                     |
|                                    | TextAreaComponent.java                 | Nguyen Quang Tri                                     |
|                                    | TextFieldComponent.java                | Nguyen Quang Tri                                     |
|                                    | ToggleMenuComponent.java               | Nguyen Quang Tri                                     |
| component.utils                    | ArrayUtil.java                         | Nguyen Quang Tri, Tran Van Toan                      |
|                                    | Element.java                           | Nguyen Quang Tri                                     |
| controller                         | Controller.java                        | Nguyen Quang Tri                                     |
|                                    | SortController.java                    | Tran Van Toan, Nguyen Quang Tri                      |
| listener                           | ScreenListener.java                    | Nguyen Quang Tri                                     |
| test.algorithm                     | *                                      | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| test.component                     | *                                      | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| test.component.utils               | *                                      | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| test.utils                         | *                                      | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| test.view                          | *                                      | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| view                               | HomeScreen.java                        | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
|                                    | MergeSortScreen.java                   |  Nguyen Thi Trang |
|                                    | Screen.java                            | Nguyen Quang Tri|
|                                    | SelectionSortScreen.java               |  Dang Kieu Trinh |
|                                    | ShellSortScreen.java                   |  Tran Van Toan |
|                                    | SortScreen.java                        | Nguyen Quang Tri, Tran Van Toan, Dang Kieu Trinh, Nguyen Thi Trang |
| Report                             | *                                      | Dang Kieu Trinh, Nguyen Thi Trang                    |
| Diagrams                           | UseCaseDiagram                         | Dang Kieu Trinh                                     |
|                                    | GeneralClassDiagram                    | Dang Kieu Trinh, Tran Van Toan, Nguyen Quang Tri     |
|                                    | DetailedClassDiagrams                  | Dang Kieu Trinh, Nguyen Thi Trang                    |
| Presentation                       | *                                      | Nguyen Thi Trang                                    |
| Demo video                         | *                                      | Dang Kieu Trinh                                     |
| Readme                             | *                                      | Dang Kieu Trinh                                     |


## Demo Video
https://drive.google.com/file/d/1NINaKk5cqqYWNSCIwZAYA4H-fRUMKnEj/view?usp=sharing
