# spring-thymeleaf-example

## Preface
This project contains a simple example with Spring Boot and Thymeleaf.

## Getting Started

You need clone the repository https://github.com/facu0202/spring-thymeleaf-example.git. If you use eclipse, you can import proyect using "import-> Existing Maven Project". 

For run application, you run de application with maven command "mvn spring-boot:run". If you use eclipse create a Maven Build and add "spring-boot:run" as Goals.

## How to uses it

You have tow url:

- http://localhost:8080/ return Hello
- http://localhost:8080/list return a table with mocks message

## Details

The application was built using "spring initializr" with the params:
- Web, Actuator, DevTools, Thymeleaf.

The application has only one controller and the magic is:

    @RequestMapping("/list")
    String list(Model model){
    	
    	model.addAttribute("messages", messagesService.findAll());
    	return "list";
    }

yes, it's exactly like Spring MVC :)

The html has:
```html
<tr th:each="message : ${messages}">
			    <td th:text="${message.id}"></td>
			    <td th:text="${message.title}"></td>
			    <td th:text="${message.text}"></td>
</tr>    
```
If you have any cuestion send and email facundoferro@gmail.com





