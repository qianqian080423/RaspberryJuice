package net.zhuoweizhang.raspberryjuice;

import org.bukkit.entity.EntityType;

public class PythonModuleGenerator {

	public static String pyEntity() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nclass Entity:\n");
		sb.append("    '''Minecraft PI entity description. Can be sent to Minecraft.spawnEntity\n");
		sb.append("\n");
		sb.append("    Do not edit this file by hand. Instead send python command\n");
		sb.append("    mc.generatePythonModules()\n");
		sb.append("    and use output in server log to populate file src/main/resources/mcpi/api/python/modded/mcpi/entity.py\n");
		sb.append("    Code changes need to be made to net.zhouweizhang.raspberryjuice.PythonModuleGenerator'''\n\n");
		sb.append("    def __init__(self, id):\n");
		sb.append("        self.id = id\n");
		sb.append("\n");
		sb.append("    def __cmp__(self, rhs):\n");
		sb.append("        return hash(self) - hash(rhs)\n");
		sb.append("\n");
		sb.append("    def __eq__(self, rhs):\n");
		sb.append("        return self.id == rhs.id\n");
		sb.append("\n");
		sb.append("    def __hash__(self):\n");
		sb.append("        return self.id\n");
		sb.append("\n");
		sb.append("    def __iter__(self):\n");
		sb.append("        '''Allows an Entity to be sent whenever id is needed'''\n");
		sb.append("        return iter((self.id,))\n");
		sb.append("\n");
		sb.append("    def __repr__(self):\n");
		sb.append("        return 'Entity(%d)'%(self.id)\n");
		sb.append("\n");
		for (EntityType entityType : EntityType.values()) {
			if ( entityType.isSpawnable() && entityType.getTypeId() >= 0 ) {
				sb.append(entityType.toString());
				sb.append("=Entity(");
				sb.append(entityType.getTypeId());
				sb.append(")\n");
			}
		}
		return sb.toString();
	}

}
