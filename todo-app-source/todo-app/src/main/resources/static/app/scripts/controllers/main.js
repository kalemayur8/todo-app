angular.module('TodoApp')
.controller('MainCtrl', ['$scope','todos','$http','$location', function ($scope,todos,$http,$location) {
	$scope.todos=todos;
	$scope.todo={};
	$scope.complete = function (todo) {
		$http.put('/todo/list/complete', todo).then(function(response){
			$scope.todos = response.data;
			$location.path('/');
		});
	}
	$scope.add = function (name) {
		$scope.todo.name=name;
		$http.post('/todo/list', $scope.todo).then(function(response){
			$scope.todos = response.data;
			$location.path('/');
		});
	}
	
	$scope.deleteTodo = function (todo) {
		$http.delete('/todo/list/'+todo.id).then(function(response){
			$scope.todos = response.data;
			$location.path('/');
		});
	}
}])