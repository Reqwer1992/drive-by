angular.module('SearchResultsApp', ['ngCookies', 'ServicesModule'])
    .controller('SearchResultsCtrl', ['$scope', '$cookieStore', '$http', 'DriveService',
        function($scope, $cookieStore, $http, DriveService) {
            $scope.greeting = "Burda6 Aleksandrov";
            $scope.destination = $cookieStore.get('to');

            $http.get("/drive/find", {params: {from:"Riga",to:"Daugavpils"}})
                .then(function(response) {
                    console.log("TROLOLO " + response.status);
                    if(response.status == 200){
                        console.log("AAAAAA");
                        console.log(response.data);
                        $("#content").html(response.data.drives[0].driveFrom);
                    }
                });
            //DriveService.getDrives("", "").then(function(response){
            //    console.log(response);
            //});

        }]
);