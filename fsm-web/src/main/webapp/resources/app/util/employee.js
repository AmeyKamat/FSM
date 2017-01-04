"use strict";
var Employee = (function () {
    function Employee(id, brid, name, group) {
        this.id = id;
        this.brid = brid;
        this.name = name;
        this.group = group;
    }
    Employee.prototype.getId = function () {
        return this.id;
    };
    Employee.prototype.getBrid = function () {
        return this.brid;
    };
    Employee.prototype.getName = function () {
        return this.name;
    };
    Employee.prototype.getGroup = function () {
        return this.group;
    };
    return Employee;
}());
exports.Employee = Employee;
//# sourceMappingURL=employee.js.map