angular.module('SearchApp', ['ServicesModule', 'ngCookies', 'spring-security-csrf-token-interceptor'])
    .controller('SearchCtrl', ['$scope', 'SearchService', '$cookieStore',
        function($scope, SearchService, $cookieStore) {

            //$scope.fromLocalities = ["Rīga", "Ventspils"];

            $scope.onSearch = function(){
                $cookieStore.put('from', $scope.from);
                $cookieStore.put('to', $scope.to);
                window.location.replace('/resources/public/search-results.html');
            };

            $scope.$watch('from', function (tmpStr){
                if (!tmpStr || tmpStr.length == 0) return 0;
                if (tmpStr === $scope.from){
                    SearchService.autocomplete(tmpStr).then(function(data){
                        $scope.fromLocalities = data.localities;
                    });
                }
            });

            $scope.$watch('to', function (tmpStr){
                if (!tmpStr || tmpStr.length == 0) return 0;
                if (tmpStr === $scope.to){
                    SearchService.autocomplete(tmpStr).then(function(data){
                        $scope.toLocalities = data.localities;
                    });
                }
            });
        }
    ]);