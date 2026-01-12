# Copilot Custom Instructions for Code Review

## Project Context
This is a Spring Boot 3.1.5 REST API service for managing shopping carts with MongoDB as the database. The application uses Java 17 and follows standard Spring Boot architectural patterns.

## Code Review Guidelines

### Code Quality Standards

#### Java Best Practices
- Follow Java naming conventions: camelCase for methods/variables, PascalCase for classes
- Use meaningful and descriptive variable names
- Keep methods focused and concise (preferably under 20 lines)
- Avoid code duplication - extract common logic into reusable methods
- Use proper exception handling with specific exception types
- Leverage Java 17 features where appropriate (records, pattern matching, text blocks)

#### Spring Boot Specific
- Use appropriate Spring annotations (@Service, @Repository, @Controller, @RestController)
- Follow RESTful API conventions for endpoint naming and HTTP methods
- Use constructor injection over field injection for dependencies
- Properly configure @RequestMapping paths to avoid conflicts
- Use appropriate HTTP status codes in responses
- Implement proper validation using @Valid and Bean Validation annotations

#### MongoDB Best Practices
- Use appropriate MongoDB annotations (@Document, @Id, @Field)
- Implement proper indexing strategies for frequently queried fields
- Handle optional results from repository methods appropriately
- Be mindful of N+1 query problems
- Use projection when retrieving partial documents

### Security Considerations

- Validate all user inputs using Bean Validation annotations
- Sanitize data before storing in MongoDB to prevent injection attacks
- Use proper error handling that doesn't expose sensitive information
- Implement appropriate authentication and authorization (if required)
- Avoid logging sensitive information (passwords, tokens, etc.)
- Use HTTPS in production environments
- Keep dependencies up to date to avoid known vulnerabilities

### Testing Requirements

- Write unit tests for all service layer methods
- Use @SpringBootTest for integration tests
- Mock external dependencies using @MockBean or Mockito
- Aim for at least 80% code coverage
- Test both success and failure scenarios
- Use meaningful test method names that describe what is being tested
- Follow Arrange-Act-Assert pattern in tests
- Use test data builders or fixtures for complex object creation

### Documentation Expectations

- Add Javadoc comments for all public classes and methods
- Document complex business logic with inline comments
- Keep README.md up to date with API changes
- Document all REST API endpoints with request/response examples
- Include error response formats in documentation
- Document configuration properties and their purposes
- Maintain changelog for version updates

### Performance Considerations

- Avoid loading unnecessary data from MongoDB
- Use pagination for endpoints that return lists
- Implement caching where appropriate (using @Cacheable)
- Be mindful of N+1 query patterns
- Use appropriate collection types (List vs Set)
- Consider lazy loading for related entities
- Profile and optimize slow queries

### Code Structure and Organization

- Follow package-by-feature or package-by-layer organization consistently
- Keep controllers thin - business logic belongs in services
- Use DTOs to separate external API contracts from internal domain models
- Implement proper separation of concerns
- Use interfaces for service contracts when beneficial
- Keep configuration classes separate from business logic

### Error Handling

- Use @ControllerAdvice for global exception handling
- Create custom exception classes for domain-specific errors
- Return appropriate HTTP status codes
- Provide meaningful error messages to clients
- Log errors with appropriate severity levels
- Don't expose stack traces to end users

### Code Formatting

- Use consistent indentation (4 spaces)
- Follow Java code formatting standards
- Keep lines under 120 characters
- Add blank lines to separate logical blocks
- Group related imports and remove unused imports
- Use braces for all control structures, even single-line statements

### Version Control

- Write clear, descriptive commit messages
- Keep commits focused and atomic
- Avoid committing generated files or dependencies
- Update .gitignore appropriately
- Reference issue numbers in commit messages when applicable

## Review Checklist

When reviewing code, ensure:
- [ ] Code follows Java and Spring Boot best practices
- [ ] All new methods have appropriate unit tests
- [ ] API endpoints follow RESTful conventions
- [ ] Input validation is implemented
- [ ] Error handling is proper and informative
- [ ] No security vulnerabilities are introduced
- [ ] Documentation is updated as needed
- [ ] No code duplication exists
- [ ] Performance implications are considered
- [ ] MongoDB queries are optimized
- [ ] Proper HTTP status codes are used
- [ ] Logging is appropriate and doesn't expose sensitive data
