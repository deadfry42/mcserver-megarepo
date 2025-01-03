# mcserver plugin megarepo
all of the plugins I custom made especially for my minecraft server!  

> [!NOTE]
> This is simply an archive of my plugin code.  
> I will likely not accept pull requests/issues unless the PR fixes technical issues / improves efficiency.  
> Also, please not I am in no way a _good_ programmer. You _will_ find mistakes & issues if you read through this code.  

> [!WARNING]
> You can use these plugins for your own server, but do NOT expect them to be plug-and-play.  
> They are specifically built for my server, and are likely not going to work in another without modification of the plugins.

Plugins and what they do:
- DFChatImprovements
  - Adds custom emojis via the format :{emojiname}:
  - (Requires a DFJavaResourcesPlus for Java, and DFBedrockResources for Bedrock)
  - Adds pinging via the format @{username}
- DFSmpPlugin
  - Used in the SMP server and the Skyblock server.
  - Adds custom content to make survival more fun.
  - Implements a custom combat logger.
  - Requires a custom resourcepack.
- DFTrueOneBlock
  - Originally intended to be a "One block Skyblock" server plugin, has expanded far too out of scope.
  - Tweaks vanilla features to be more suited for skyblock (coming soon)
  - Implements a custom GUI
  - Can run on one server, all of the skyblock worlds are different files (probably, hasn't been implemented yet)
- DFProxyPlugin
  - A simple velocity plugin to send a chat message when the player joins.
- DFLobbyPlugin
  - Teleports players to the world spawn when joined
  - Supresses join / leave messages
  - Implements custom commands to join different servers in the same BungeeCord/Velocity (with bc compatibility enabled) server.
- DFInhibition
  - Prevents players from modifying the world in any way before the /startsmp command is run
  - Prevents players from entering the nether, the end and pvping until their respective commands have been run.
  - Commands can only be ran on the server console.

Other:
- DFJavaResourcesPlus
  - Resource pack for DFSmpPlugin for Java edition
- DFBedrockResources
  - Resource pack for DFSmpPlugin for Bedrock edition
  - Requires GeyserMC Bindings (dfsmpitems.json)
