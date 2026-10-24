# Task 2: Student Grade Calculator

A comprehensive console-based Student Grade Calculator built in Java for the CodSoft Java Development Internship.

---

## 🎯 Task Description
1. **Input**: Take marks obtained (out of 100) in each subject.
2. **Calculate Total Marks**: Sum up the marks obtained in all subjects.
3. **Calculate Average Percentage**: Divide total marks by the total number of subjects to compute average percentage.
4. **Grade Calculation**: Assign letter grades based on the average percentage achieved.
5. **Display Results**: Show the total marks, average percentage, and the corresponding grade to the user.

---

## 🚀 Features
- **Dynamic Subject Support**: Allows the user to specify any number of subjects with custom or default names.
- **Robust Input Validation**: Validates that marks are within `[0, 100]` and rejects negative numbers or non-numeric inputs without crashing.
- **Grading Scale**:
  - `90% - 100%`: **A+** (Outstanding)
  - `80% - 89.9%`: **A** (Excellent)
  - `70% - 79.9%`: **B** (Very Good)
  - `60% - 69.9%`: **C** (Good)
  - `50% - 59.9%`: **D** (Satisfactory)
  - `40% - 49.9%`: **E** (Pass)
  - `Below 40%`: **F** (Fail)
- **Formatted Report Card**: Displays an organized summary table with marks per subject, total marks, percentage, grade, and evaluation remarks.
- **Multi-Student Support**: Allows evaluating multiple students in a single session.

---

## 🛠️ How to Compile & Run

### 1. Compile
```bash
javac Task2_StudentGradeCalculator/src/StudentGradeCalculator.java
```

### 2. Run
```bash
java -cp Task2_StudentGradeCalculator/src StudentGradeCalculator
```
