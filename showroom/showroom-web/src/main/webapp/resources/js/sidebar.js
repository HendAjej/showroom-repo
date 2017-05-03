/*
 * including sidebar items in bootstrap nav items
 * @author Harzli Joumen
 */
"use strict";
$(document).ready(function() {
	var sm_screen = 768;
	var sidebar = $("#sidebar ul");
	var sidebarItem = $("#sidebar ul li");
	var nav = $("#menu ul");
	var navItem = $("#menu ul li");

	var arr_nav;
	var arr_sidebar;

	function loadNav() {
		arr_sidebar = $.makeArray(sidebarItem);
	}

	function loadSideBar() {
		arr_nav = $.makeArray(navItem);
	}

	function smallScreen() {
		sidebarItem.remove();
		navItem.remove();
		for ( var i in arr_sidebar) {
			nav.append(arr_sidebar[i]);
		}
		for ( var j in arr_nav) {
			nav.append(arr_nav[j]);
		}
	}

	function bigScreen() {
		sidebarItem.remove();
		navItem.remove();
		for ( var i in arr_sidebar) {
			sidebar.append(arr_sidebar[i]);
		}
		for ( var j in arr_nav) {
			nav.append(arr_nav[j]);
		}
	}

	function check() {
		var w = $(window).width();
		sidebar.each(function(index, li) {
			if (w > sm_screen) {
				bigScreen();
			} else {
				smallScreen();
			}
		});
	}

	$(window).bind('resize', function() {
		check();
	});
	loadSideBar();
	loadNav();
	check();
});
