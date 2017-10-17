var baseUrl = "http://localhost:8080/api";

(function () {
  var app = angular.module('taskApp', ['ngMaterial', 'ngResource']);
  app.controller('TaskListController', function ($scope, $resource) {
    $resource.get(baseUrl + '/tasks').then(function (response) {
      var taskData = response.data;
      $scope.tasks = taskData;
      //        console.log($scope.tasks);
    });
  });

  app.controller('AddTaskController', function ($scope, $resource) {
    console.log($scope.newTask);

    // $resource.post(baseUrl + '/tasks').then(function (request) {
    // });
  });

})();








// // var todoList = this;
// todoList.todos = [


//   todoList.addTodo = function () {
//     todoList.todos.push({ text: todoList.todoText, done: false });
//     todoList.todoText = '';
//   };

//   todoList.remaining = function () {
//     var count = 0;
//     angular.forEach(todoList.todos, function (todo) {
//       count += todo.done ? 0 : 1;
//     });
//     return count;
//   };

//   todoList.archive = function () {
//     var oldTodos = todoList.todos;
//     todoList.todos = [];
//     angular.forEach(oldTodos, function (todo) {
//       if (!todo.done) todoList.todos.push(todo);
//     });
//   };
//   });