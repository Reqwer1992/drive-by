var mainApp = angular.module('mainApp', ['ServicesModule']);

mainApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/search', {controller:SearchCtrl, template:'search.html'}).
            when('/searchResults', {controller:SearchResultsCtrl, template:'search-results.html'});
    }]);

mainApp.controller('SearchResultsCtrl', ['$scope', 'SearchService',
    function($scope, SearchService) {
        console.log(SearchService.getFrom());
    }]);

mainApp.controller('SearchCtrl', ['$scope', '$location', 'SearchService',
    function($scope, $location, SearchService) {
        $scope.greeting = "Aleksandr Burda6ev";
        console.log($scope.greeting);
        $scope.onSearch = function(){
            SearchService.setFrom("Rīga");
            console.log(SearchService.getFrom());
            SearchService.setTo("Daugavpils");
            $location.path('search-results.html');
        };
    }
]);