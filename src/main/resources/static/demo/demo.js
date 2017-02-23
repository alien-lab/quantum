/**
 * Created by 橘 on 2017/1/12.
 */
(function(){
    'use strict';
    var demoapp=angular.module("demoapp",[]);
    demoapp.controller("demoController",["$scope","$filter",function($scope,$filter){
        $scope.title="Demo标题";
        $scope.array=[
            {
                key:"k111",
                value:"v111"
            },{
                key:"k222",
                value:"v222"
            },{
                key:"k333",
                value:"v333"
            },{
                key:"k444",
                value:"v444"
            }
        ];
        $scope.btnclick=function(){
            $scope.array.push({
                key:"k-"+new Date().getTime(),
                value:"v-"+new Date().getTime()
            });
        }
        $scope.delItem=function(item){
            for(var i=0;i<$scope.array.length;i++){
                if($scope.array[i].key==item.key){
                    $scope.array.splice(i,1);
                    break;
                }
            }
        }
    }]);
})();