var baseUrl = "http://localhost:8081/api"
var app = angular.module('taskApp', ['ngMaterial']);
(function () {

  app.controller('TaskController', function ($scope, $http, $location, $mdDialog) {

    $scope.getTasks = function () {
      $http.get(baseUrl + '/tasks').then(function (response) {
        var taskData = response.data;
        $scope.tasks = taskData;
      })
    };

    $scope.remaining = function () {
      var count = 0;
      angular.forEach($scope.tasks, function (tasks) {
        count += tasks.complete ? 0 : 1;
      });
      return count;
    };

    $scope.addTask = function () {
      var task = {
        content: $scope.newTask
      };
      $http.post(baseUrl + '/tasks', task).then(function success(response) {
        console.log(response);
        $scope.newTask = '';
        $scope.getTasks();
      },
        function fail(response) {
          console.log(response);
        });
    };

    $scope.viewTask = function (id, content, ev) {
      $mdDialog.show({
        controller: DialogController,
        templateUrl: '/app/src/tasks/view/dialog1.tmpl.html',
        parent: angular.element(document.body),
        targetEvent: ev,
        targetId: id,
        clickOutsideToClose: true,
        fullscreen: $scope.customFullscreen, // Only for -xs, -sm breakpoints.
        locals: {
          id: id,
          content: content
        }
      })
        .then();
    };

    $scope.deleteTask = function (id) {
      $http.delete(baseUrl + '/tasks/' + id).then(function success(response) {
        console.log(response);
        $scope.getTasks();
      },
        function fail(response) {
          console.log(response);
        });
    }
    $scope.getTasks();

    function DialogController($scope, $mdDialog, id, content) {
      $scope.id = id;
      $scope.content = content;
      $scope.hide = function () {
        $mdDialog.hide();
      };
      $scope.cancel = function () {
        $mdDialog.cancel();
      };
    }

  });

  app.config(function ($mdThemingProvider, $mdIconProvider) {

    $mdThemingProvider.theme('default')
      .primaryPalette('indigo')
      .accentPalette('blue')
      .warnPalette('red')
      .backgroundPalette('indigo');
  });
})();