angular.module('newUserApp', ['common', 'spring-security-csrf-token-interceptor', 'editableTableWidgets'])
    .controller('NewUserCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.uploadFile = function(event){
            var files = event.target.files;
            $scope.vm.profilePicture = files[0];
            console.log($scope.vm.profilePicture);
        };

        $scope.createUser = function () {
            console.log('Creating user with username ' + $scope.vm.username + ' and password ' + $scope.vm.password);

            $scope.vm.submitted = true;

            if ($scope.form.$invalid) {
                return;
            }

            var postData = {
                username: $scope.vm.username,
                plainTextPassword: $scope.vm.password,
                email: $scope.vm.email
            };
            console.log(postData);
            var fd = new FormData();
            fd.append('data', new Blob([angular.toJson(postData)], {
                type: "application/json"
            }));
            //fd.append("username", $scope.vm.username);
            //fd.append("email", $scope.vm.email);
            //fd.append("plainTextPassword", $scope.vm.password);
            fd.append("profilePicture", $scope.vm.profilePicture);

            console.log(fd);
            $http.post("/user", fd, {
                transformRequest : angular.identity,
                headers : {
                    'Content-Type' : undefined
                }
            })
            .success(function(data) {
                console.log(data);
            })
            .error(function(data) {
                console.log(data);
            });

            //$http({
            //    method: 'POST',
            //    url: '/user',
            //    data: postData,
            //    headers: {
            //        "Content-Type": "application/json",
            //        "Accept": "text/plain"
            //    }
            //})
            //.then(function (response) {
            //    if (response.status == 200) {
            //        $scope.login($scope.vm.userName, $scope.vm.password);
            //    }
            //    else {
            //        $scope.vm.errorMessages = [];
            //        $scope.vm.errorMessages.push({description: response.data});
            //        console.log("failed user creation: " + response.data);
            //    }
            //});
        }
    }])
    .directive('customOnChange', function() {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                var onChangeHandler = scope.$eval(attrs.customOnChange);
                element.bind('change', onChangeHandler);
            }
        };
    });