# GPA to Percent Range Converter

This Java program accepts a student's GPA and outputs the matching percent range based on the grading scheme for the assignment.

- Accepts GPA input from the user
- Uses a switch statement to determine the percent range
- Displays the corresponding percent range
- Validates GPA input to make sure it is between 0.0 and 4.0

## How to Run
1. Open the project in IntelliJ IDEA.
2. Open `GpaToPercent.java` in the `src` folder.
3. Click the green run button next to the `main` method.
4. Enter a GPA when prompted.

## Example Input
```text
3.5
```

## Example Output
```text
Percent Range: < 91.0% to 90.0%
```

## Test Cases
### Normal Cases
- 4.0 → 100% to 95.0%
- 3.5 → < 91.0% to 90.0%
- 2.1 → < 77.0% to 76.0%

### Edge Cases
- 0.0 → < 65.0% to 0.0%
- 4.1 → Invalid GPA
- -1.0 → Invalid GPA

## Author
Mahir Krishnan
