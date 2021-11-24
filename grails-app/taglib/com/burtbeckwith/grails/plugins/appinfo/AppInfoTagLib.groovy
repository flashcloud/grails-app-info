package com.burtbeckwith.grails.plugins.appinfo

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class AppInfoTagLib {

	static namespace = 'ai'

	def pluginManager

	def resources = { attrs ->
		if (pluginManager.hasGrailsPlugin('resources')) {
			r.require(module: 'appInfo')
			out << r.resources()
		}
		else {
			out << g.javascript(library: 'jquery', plugin: 'jquery')
			for (name in ['jquery.jdMenu', 'jquery.jdMenu.slate',
			              'tabs', 'tabs-accordion', 'appinfo']) {
				out << """<link rel="stylesheet" media="screen" href="${resource(dir:'css',file:"${name}.css",plugin:'appInfo')}"/>"""
			}
			for (name in ['media/css/jquery.dataTables.min', '/media/css/jquery.dataTables_themeroller']) {
				out << """<link rel="stylesheet" media="screen" href="${resource(dir:'DataTables-1.10.6',file:"${name}.css",plugin:'appInfo')}"/>"""
			}
			for (name in ['extensions/TableTools/css/dataTables.tableTools.min']) {
				out << """<link rel="stylesheet" media="screen" href="${resource(dir:'DataTables-1.10.6',file:"${name}.css",plugin:'appInfo')}"/>"""
			}
			for (name in ['appInfo.dataTable']) {
				out << "<script type='text/javascript' src='${resource(dir: 'js', file: name + '.js', plugin: 'appInfo')}'></script>"
			}
			for (name in ['media/js/jquery.dataTables.min']) {
				out << "<script type='text/javascript' src='${resource(dir: 'DataTables-1.10.6', file: name + '.js', plugin: 'appInfo')}'></script>"
			}
			for (name in ['extensions/TableTools/js/dataTables.tableTools.min']) {
				out << "<script type='text/javascript' src='${resource(dir: 'DataTables-1.10.6', file: name + '.js', plugin: 'appInfo')}'></script>"
			}
		}
	}

	def layoutResources = { attrs ->
		if (pluginManager.hasGrailsPlugin('resources')) {
			out << r.layoutResources()
		}
		else {
			for (name in ['jquery/jquery.dimensions', 'jquery/jquery.jdMenu', 'jquery/jquery.bgiframe',
			              'jquery/jquery.positionBy', 'jquery/jquery.tabs.min']) {
				out << "<script type='text/javascript' src='${resource(dir: 'js', file: name + '.js', plugin: 'appInfo')}'></script>"
			}
		}
	}
}
