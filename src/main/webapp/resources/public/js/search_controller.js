angular.module('SearchApp', ['ServicesModule', 'ngCookies'])
    .controller('SearchCtrl', ['$scope', '$cookieStore', 'SearchService',
        function($scope, $cookieStore, SearchService) {
            $scope.greeting = "Aleksandr Burda6ev";
            console.log($scope.greeting);
            $scope.onSearch = function(){
                $cookieStore.put('from', 'Rīga');
                $cookieStore.put('to', 'Daugavpils');
                window.location.replace('/resources/public/search-results.html');
            };
        }
    ]);