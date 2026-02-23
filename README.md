# SNHU-CS-320-Software-Testing

## Portfolio Artifacts

This repository contains selected artifacts from CS 320: Software Testing, Automation, and QA.

- **Project One:** Contact Service (Contact.java, ContactService.java, ContactTest.java, ContactServiceTest.java)
- **Project Two:** Summary and Reflections Report

These projects demonstrate my ability to design software based on requirements, implement validation logic, and create comprehensive unit tests using JUnit to verify functionality and uncover defects.

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure that my software is functional, I focus on writing unit tests that directly align with the documented requirements. In Project One, I created tests that validated both positive and negative scenarios, including invalid inputs and boundary conditions. By testing expected behavior as well as failure cases, I was able to confirm that the system enforced constraints correctly.

Security begins with strong validation. I ensured that fields such as IDs, names, and descriptions were non-null, properly bounded in length, and protected from unintended modification. Writing defensive code and validating inputs helps prevent vulnerabilities and logical errors. I also structure my code clearly and follow object-oriented principles to reduce unintended side effects.

---

### How do I interpret user needs and incorporate them into a program?

I begin by carefully reviewing the software requirements and translating them into measurable behaviors. Each requirement should map to either a method implementation or a test case. In these projects, I treated requirements as rules that the system must enforce, such as uniqueness constraints or length limits.

Once requirements are clearly defined, I break them into smaller, testable components. This allows me to design classes and services that directly reflect user expectations. Writing unit tests based on requirements ensures that the implementation stays aligned with the intended functionality.

---

### How do I approach designing software?

My approach to software design begins with understanding the problem and identifying the core entities involved. I then design classes that represent those entities and define clear responsibilities for each. Applying object-oriented principles such as encapsulation and separation of concerns helps keep the code modular and maintainable.

Before implementing complex logic, I consider how it will be tested. Designing with testing in mind results in cleaner methods, clearer validation logic, and fewer unintended dependencies. Throughout these projects, I focused on building small, well-defined components and verifying them incrementally through unit testing.

Overall, these projects strengthened my understanding of how thoughtful design, requirement analysis, and automated testing work together to produce reliable and maintainable software.
