<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8" />
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/style1.css" />
        <script src="https://kit.fontawesome.com/10bd40efd3.js"></script>
        <script type="text/javascript" src="todos.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark">
            <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Profile </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Profile</a> <a class="dropdown-item" href="#">Settings</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="logout">Logout</a>
                </div>
            </li>
            <div class="text-center">
                <h2 class="todotitle">ToDoApp</h2>
            </div>
        </nav>

        <div align="center">
            <form action="add" method="post">
                <input type="text" name="description" id="description" placeholder="Add a ToDo" required="required">
                <input type="date" name="date" id="date" value="date" required="required">
                <input type="submit" id="addButton" value="Add!" />
            </form>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-dark">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Description</th>
                        <th scope="col">Created Date</th>
                        <th scope="col">Due Date</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos }" var="todo" varStatus="counter">
                        <tr>

                            <td>${counter.count }</td>
                            <td>${todo.description}</td>
                            <td>${todo.createdDate}</td>
                            <td>${todo.dueDate}</td>
                            <td>Active</td>
                            <td>
                                <div class="btn-group">
                                    <form action="delete" method="POST">
                                        <input type="hidden" name="todoID" value="${todo.todos_id}" />
                                        <button class="button" type="submit">

                                            <i class="fas fa-trash"></i>
                                        </button>
                                    </form>

                                    <button class="button" onclick="openForm(this)" id=todoID value="${todo.todos_id }">
                                        <i class="fas fa-edit"></i>

                                    </button>

                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="form-popup">
            <div class="popup-content">
                <form action="update" method="POST">
                    <input type="hidden" name="todoid" id="todoid" value="${todo.todos_id}" />
                    <p style="color: white;">Description</p>
                    <br>
                    <input type="text" name="description" autocomplete="off" value="${todo.description }" required placeholder="${todo_description }">
                    <br>
                    <p style="color: white;">Date</p>
                    <br>
                    <input type="date" name="date" required value="${todo.dueDate }">
                    <br>
                    <br>
                    <button class="button" type="submit">
                        <i class="fas fa-check-circle"></i>
                    </button>
                    <button type="button" class="closeBtn" onclick="closeForm()">
                        <i class="fas fa-times"></i>
                    </button>
                </form>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
        </script>
    </body>

    </html>