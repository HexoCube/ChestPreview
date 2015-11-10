/*
 * Copyright 2015 hexosse
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.hexosse.chestpreview.command;

import com.github.hexosse.baseplugin.command.BaseCommand;
import com.github.hexosse.baseplugin.utils.LocationUtil;
import com.github.hexosse.chestpreview.ChestPreview;
import com.github.hexosse.chestpreview.configuration.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This file is part ChestPreview
 *
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */
public class CommandList extends BaseCommand<ChestPreview>
{
    /**
     * @param plugin The plugin that this object belong to.
     */
    public CommandList(ChestPreview plugin)
    {
        super(plugin);
    }

    /**
     * Abstarct metode
     */
    @Override
    public void execute(CommandSender sender)
    {
        final Player player = (sender instanceof Player) ? (Player)sender : null;

        if(!Permissions.has(sender, Permissions.ADMIN))
        {
            pluginLogger.help(ChatColor.RED + plugin.messages.AccesDenied, player);
            return;
        }

        if(plugin.config.chests.size()==0)
            return;

        pluginLogger.help(ChatColor.YELLOW + "-----------------------------------------------", player);
        pluginLogger.help(ChatColor.YELLOW + plugin.getDescription().getName() + " list (" + String.valueOf(plugin.config.chests.size()) + ")", player);
        for(Location location : plugin.config.chests)
            pluginLogger.help(ChatColor.WHITE + LocationUtil.locationToString(location), player);
        pluginLogger.help(ChatColor.YELLOW + "-----------------------------------------------", player);
    }
}