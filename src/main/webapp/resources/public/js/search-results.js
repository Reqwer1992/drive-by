angular.module('SearchResultsApp', ['ngCookies'])
    .controller('SearchResultsCtrl', ['$scope', '$cookieStore',
        function($scope, $cookieStore) {
            $scope.greeting = "Burda6 Aleksandrov";
            $scope.destination = $cookieStore.get('to');
            console.log($cookieStore.get('from'));
        }]
);