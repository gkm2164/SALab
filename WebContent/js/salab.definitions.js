var SALab = {
	Utility: {},
	Home: {}, Members: {}, Publications: {},
	Researches: {}, Activities: {}, Courses: {},
	Resources: {},
};

SALab.Utility.funcPrototype = function () {
	alert ("Hello!");
};
SALab.Utility.namespace = function (ns) {
	var nsarr = [];
	
	nsarr = ns.split (".");
	if (nsarr[0] == "SALab") {
		nsarr.slice (1);
	}
	
	var i = 0,
		iLimit = nsarr.length;
	var parent = SALab;
	
	for (; i < iLimit; i += 1) {
		var name = nsarr[i];
		if (parent[name] == "undefined") {
			parent[name] = {};
		}
		parent = parent[name];
	}
	
	return parent;
};
SALab.Utility.extendObject = function (dst, src) {
	for (var key in src) {
		dst[key] = dst[key] || src[key];
	}
	
	return dst;
};

SALab.Utility.extendObject (this, SALab.Utility);