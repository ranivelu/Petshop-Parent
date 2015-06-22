var app=angular.module('myApp',[]);        
app.filter('filterByProperty', function () {
        /* array is first argument, each addiitonal argument is prefixed by a ":" in filter markup*/
        return function (dataArray, searchTerm, propertyName) {
            if (!dataArray) return;
            /* when term is cleared, return full array*/
            if (!searchTerm) {
                return dataArray
            } else {
                /* otherwise filter the array */
                var term = searchTerm.toLowerCase();
                return dataArray.filter(function (item) {
                    return item[propertyName].toLowerCase().indexOf(term) > -1;
                });
            }
        }
    });
    
    <input type="text" ng-model="filterText" />

<table>
  <tr ng-repeat="item in data |filterByProperty:filterText:'name'"><td>{{    item.id }}</td><td>{{ item.name }}</td>...</tr>
</table>

<input type="text" ng-model="filterText" />
<table>
      <tr ng-repeat="item in data"><td>{{ item.id }}</td><td>{{ item.name }}</td>...</tr>
</table>