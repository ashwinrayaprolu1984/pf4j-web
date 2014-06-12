/**
 * 
 */
package org.rmrodrigues.pf4j.web;

import java.io.File;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;

// TODO: Auto-generated Javadoc
/**
 * The Class PluginManagerHolder.
 * 
 * @author rmrodrigues
 */
public class PluginManagerHolder {

	/** The instance. */
	private static PluginManagerHolder instance;

	/** The plugins folder. */
	private String pluginsFolder;

	/** The plugin manager. */
	private PluginManager pluginManager;

	/** The has custom plugin path. */
	boolean hasCustomPluginPath = false;

	/**
	 * Instantiates a new plugin manager holder.
	 */
	private PluginManagerHolder() {
		initialize();

	}

	/**
	 * Instantiates a new plugin manager holder.
	 * 
	 * @param path
	 *            the path
	 */
	private PluginManagerHolder(String path) {
		this.pluginsFolder = path;
		this.hasCustomPluginPath = true;
		initialize();
	}

	/**
	 * Inits the.
	 * 
	 * @param dataPath
	 *            the data path
	 */
	public static void init(String dataPath) {
		if (dataPath == null) {
			instance = new PluginManagerHolder();
		} else {
			instance = new PluginManagerHolder(dataPath);
		}

	}

	/**
	 * Gets the single instance of PluginManagerHolder.
	 * 
	 * @return single instance of PluginManagerHolder
	 */
	public static PluginManagerHolder getInstance() {
		if (instance == null)
			instance = new PluginManagerHolder();
		return instance;
	}

	/**
	 * Initialize.
	 */
	private void initialize() {
		if (this.hasCustomPluginPath) {
			pluginManager = new DefaultPluginManager(new File(
					this.pluginsFolder));
		} else {
			pluginManager = new DefaultPluginManager();
		}

	}

	/**
	 * Gets the plugin manager.
	 * 
	 * @return the plugin manager
	 */
	public static PluginManager getPluginManager() {
		return PluginManagerHolder.getInstance().getPluginManager();
	}

}