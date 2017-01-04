"use strict";
var Group = (function () {
    function Group(id, name, parentGroup) {
        this.id = id;
        this.name = name;
        this.parentGroup = parentGroup;
    }
    Group.prototype.getId = function () {
        return this.id;
    };
    Group.prototype.getName = function () {
        return this.name;
    };
    Group.prototype.getParentGroup = function () {
        return this.parentGroup;
    };
    return Group;
}());
exports.Group = Group;
//# sourceMappingURL=group.js.map