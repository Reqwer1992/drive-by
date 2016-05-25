angular.module('SearchResultsApp', ['ngCookies', 'ServicesModule'])
    .controller('SearchResultsCtrl', ['$scope', '$cookieStore', '$http', 'DriveService',
        function($scope, $cookieStore, $http, DriveService) {
            $scope.greeting = "Burda6 Aleksandrov";
            $scope.destination = $cookieStore.get('to');
            $scope.source = $cookieStore.get('from');


            $http.get("/drive/find?from=" + $scope.source + "&to=" + $scope.destination, {header : {'Content-Type' : 'application/json; charset=UTF-8'}})
                .then(function(response) {
                    if(response.status == 200){
                        $("#content").html(response.data.drives[0].driveFrom);
                    }
                });
        }]
);