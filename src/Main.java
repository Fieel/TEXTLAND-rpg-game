
public class Main  extends Variables {

		public static void start(){
			
			System.out.println("\nd888888b db   db d88888b ");
			System.out.println("`~~88~~' 88   88 88'     ");
			System.out.println("   88    88ooo88 88ooooo ");
			System.out.println("   88    88~~~88 88~~~~~ ");
			System.out.println("   88    88   88 88.     ");
			System.out.println("   YP    YP   YP Y88888P ");
			System.out.println("                         ");
			System.out.println("                         ");
			System.out.println("d888888b d88888b db    db d888888b db       .d8b.  d8b   db d8888b. ");
			System.out.println("`~~88~~' 88'     `8b  d8' `~~88~~' 88      d8' `8b 888o  88 88  `8D ");
			System.out.println("   88    88ooooo  `8bd8'     88    88      88ooo88 88V8o 88 88   88 ");
			System.out.println("   88    88~~~~~  .dPYb.     88    88      88~~~88 88 V8o88 88   88 ");
			System.out.println("   88    88.     .8P  Y8.    88    88booo. 88   88 88  V888 88  .8D ");
			System.out.println("   YP    Y88888P YP    YP    YP    Y88888P YP   YP VP   V8P Y8888D' ");
			System.out.println("                                                                   "); 
			System.out.println("                                                                ");    
			System.out.println("d8888b. d8888b.  d888b     d888b   .d8b.  .88b  d88. d88888b ");
			System.out.println("88  `8D 88  `8D 88' Y8b   88' Y8b d8' `8b 88'YbdP`88 88'     ");
			System.out.println("88oobY' 88oodD' 88        88      88ooo88 88  88  88 88ooooo ");
			System.out.println("88`8b   88~~~   88  ooo   88  ooo 88~~~88 88  88  88 88~~~~~ ");
			System.out.println("88 `88. 88      88. ~8~   88. ~8~ 88   88 88  88  88 88.     ");
			System.out.println("88   YD 88       Y888P     Y888P  YP   YP YP  YP  YP Y88888P");
			
			System.out.println("\nCreated by ©Event Horizon Studios.");
			
			System.out.println("\nThis game is a text adventure.");
			System.out.println("You will be able to interact with the game with the keyboard and pressing Enter.");
			System.out.println("To interact with the game just write your answer and press Enter.");
			
			System.out.println("\nYou wake up in the middle of a sunny day. There's a nice breeze being transported by the wind."
					+ "\nYou can't remember anything. You just woke up here and nothing else."
					+ "\nAfter some minutes your memory starts to come back. You start to distinguish the details about the environment around you."
					+ "\nApparently you are located at the center of a mysterious world and your only hope is to get as far as possible."
					+ "\nAfter some minutes your memory starts to come back and you try to remember your name:");
			System.out.println("(insert your name)");
			name = input.next();
			
			sleep();
			
			System.out.println("\nOkay, my name is " + name + ". I wonder what happened before you wake up here."
					+ "\nAnyways, you're still confused. This might sound ridiculous... but am i a male or female?");
			boolean testgender = true; //this small loop continues to ask the user the gender if something else than "male" or "female" is input
			while (testgender){
				gender = input.next().toLowerCase();
				
				if (gender.equals("male")){
					testgender = false;
					break;
				}
			
				if (gender.equals("female")){
					testgender = false;
					break;
				} else 
					System.out.println("Please answer with 'male' or 'female', please..\n");
			}
			
			System.out.println("\nAllright! Who am i? Why am i here, why can't i remember anything?"
					+ "\nI know inside me that i have to go straight forward. That way, i will be able to get home."
					+ "\nI can move left and right in case i want to further explore this mysterious world."
					+ "\nI prepare my equipment and my items. I'll have to start moving soon.");
		}
		
		public static void win() {
			
			System.out.println("\n__   __  _______  __   __    _     _  ___   __    _  __  ");
			System.out.println("|  | |  ||       ||  | |  |  | | _ | ||   | |  |  | ||  | ");
			System.out.println("|  |_|  ||   _   ||  | |  |  | || || ||   | |   |_| ||  | ");
			System.out.println("|       ||  | |  ||  |_|  |  |       ||   | |       ||  | ");
			System.out.println("|_     _||  |_|  ||       |  |       ||   | |  _    ||__| ");
			System.out.println("  |   |  |       ||       |  |   _   ||   | | | |   | __  ");
			System.out.println("  |___|  |_______||_______|  |__| |__||___| |_|  |__||__| ");
			
			System.out.println("\nYou win! You reached the end of the world and you managed to escape this mysterious land.");
			System.out.println("It took you "+Game.days+" days to find a way out. Congratulations, "+Character.name+"!");
			System.out.println("\nThank you for playing!");
			System.out.println("\n©Created by Event Horizon Studios.");
			
		}
		
		public static void rightstop(){
			System.out.println("\nYou can't move to the right. You can't explain it, but you feel like it wouldn't be a good decision.");
		}
		
		public static void leftstop(){
			System.out.println("\nThe way is blocked. You can't go left. You have to choose another direction.");
		}
		
		public static void endHP(){
			System.out.println("\n::::::::     :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  ");
			System.out.println(":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: ");
			System.out.println("+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ ");
			System.out.println(":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  ");
			System.out.println("+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ ");
			System.out.println("#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# ");
			System.out.println(" ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### ");
			
			System.out.println("\nYou die agonizing and choking on your own blood. Unfortunately your HP did fall below 0.");
			System.out.println("Your corpse will rot here forever and you will be forgotten. You will never know why you woke up in this strange world.");
			System.out.println("It took you, "+Character.name+"; "+Game.days+" days to find a way to get killed.");
			System.out.println("\n            .-.");
			System.out.println("              | |____________________________________________________");
			System.out.println(" _ _ _ _ _ _ _| |                                                  .'`.");
			System.out.println("|_|_|_|_|_|_|_| |-Produced by Event Horizon studios--------------.'****>");
			System.out.println("`.            | |_______________________________________________.'***.'");
			System.out.println("  `.        .'| |                                               `**'");
			System.out.println("    `-.___.'  `-'                                              .'*`.");
			System.out.println("                                                               `._.' .");
			System.out.println("                                                               .   .'*`.");
			System.out.println("                                                             .'*`. `._.'");
			
		}
		
		public static void endFood(){
			System.out.println("\n::::::::     :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  ");
			System.out.println(":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: ");
			System.out.println("+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ ");
			System.out.println(":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  ");
			System.out.println("+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ ");
			System.out.println("#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# ");
			System.out.println(" ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### ");
			
			System.out.println("\nYou ran out of food and died out of hunger. You should try to find some food the next time.");
			System.out.println("Apparently you will die here without any hope to find out why appeared in this world in the first place.");

			System.out.println("It took you, "+Character.name+"; "+Game.days+" days to find a way to starve to death.");
			System.out.println("What a shame.");
			
			System.out.println("\n     _                                                 _.--.    __  _");
			System.out.println("    | |                                               ) |   `.,'  || |");
			System.out.println("    | |                                            (`'       |     : |");
			System.out.println("    | |                             _..-.-.-.-._    )     ,),'.    | |");
			System.out.println("    | |('.                    __..-' ) ) ) ) ) )``-'    _.-| |     | |");
			System.out.println("    | | | `...------''``--'''' |   )_____....---     ,''           ; |");
			System.out.println("    | |_(_..-......_________..._,-'_,..__....____..-'.._________..'| |");
			System.out.println("    | |____________________________________________________________| |");
			System.out.println("  __|_|___________Produced by Event Horizon Studios_____________SSt|_|__");
			
			
		}

		public static void endWater(){
			System.out.println("\n::::::::     :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  ");
			System.out.println(":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: ");
			System.out.println("+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ ");
			System.out.println(":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  ");
			System.out.println("+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ ");
			System.out.println("#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# ");
			System.out.println(" ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### ");
			
			System.out.println("\nYou died from thirst. You can no longer walk and you haven't a single drop of water to drink.");
			System.out.println("You died in the middle of nowhere and your mission failed. Noone will remember you.");
			
			System.out.println("It took you, "+Character.name+"; "+Game.days+" days to die agonizing without water.");
			
			System.out.println("\n   -     -   - ---- ---- - -   -   -- -   ----- - r    -      -");
			System.out.println("-------------------------------------------------r   -----------");
			System.out.println("---/----//--//////--////--/----/---------//////-/r   //r -----//");
			System.out.println("////////rr//////////////////////////////////r  //r   //r ////rrr");
			System.out.println("///////   r///rrr///rr///r////r/////////rrrrr   /r   rr  ////r");
			System.out.println("rrrrrrr   rr rrrrrrrrrrrrrrrrLorrrrrrrrrrrrrr   rr      rrrrr");
			System.out.println("rrrrrrL   rr rLLrrrrLrrorrrrrLoLrrrrLLorLLLLr   rr    rrrrrrr");
			System.out.println("LLLLLLL     rLLLLLLLLLLLooLLLoooLLoLooLLLLLLLr        LLLLLr");
			System.out.println("LLLLooo   rrooooooooooLLooo@@@@@@@@ooLoooooooorrrr    LLLLLr");
			System.out.println("ooooooo   roooooooooooooo@@@@@@@@@@@@oooooooooooor    oooorr");
			System.out.println("ooooooo   rooooooooooooo@@@@@@@@@@@@@@ooooooooooor    ooorr");
			System.out.println("........   r........sss...........................r    ..........");
			System.out.println("......  ........      ssss........................r    ...........");
			System.out.println("....  ......Produced by Event Horizon Studios.....r    ..........");
			System.out.println("..  ............       ..............................   ...........");
			System.out.println(" .............     .s  = =........,...................   ..........");
			System.out.println("..............    .ss  == ==.....,......................    ..........");
			System.out.println("..............          == ==.........o...................   .......");
			System.out.println(".............            == == ,,,,@,,,,,,..................    ....");
			System.out.println("..............           bb#bbb#,,@@,,@,,,,,,,,,,.............    ....");
			System.out.println(".....................,,,,,,,,,,,,@@@@@@@@,,,,,,,,,,,,..........     ..");
			System.out.println("........................,,,,,,,,,^^^^^^^^,,,,,,,,,,.............");
		}
		
		public static void endStamina(){
			System.out.println("\n::::::::     :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  ");
			System.out.println(":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: ");
			System.out.println("+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ ");
			System.out.println(":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  ");
			System.out.println("+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ ");
			System.out.println("#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# ");
			System.out.println(" ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### ");
			
			System.out.println("\nYou died out of exhaustation. Unfortunately your stamina reached 0.");
			System.out.println("You felt on the ground and your corpse starter rotting. Your flesh will be eaten by worms and everyone will forget you");

			System.out.println(Character.name+" managed to travel for "+Game.days+" days.");
			
			System.out.println("\n          /`.__     ,");
			System.out.println("         /     |   / |");
			System.out.println("         ) ,-==-> /|/ |");
			System.out.println("          )__\\/ // |  |");
			System.out.println("         /  /' |//   | |");
			System.out.println("        /  (  /|/    | /");
			System.out.println("       /     //|    /,'");
			System.out.println("      // /  (( )    '");
			System.out.println("    //     (#) |");
			System.out.println("   /        )|/ |   '       ____");
			System.out.println("     //     // |    |");
			System.out.println(" Produced by Event Horizon Studios_,,--=_,");
			System.out.println(" /         |#|  /)      __/ + |____,--==<");
			System.out.println(" //________/#/_/'      (|_|__+/_,   ---<^");
			System.out.println("                                '==--=='");
			
		}
		
		public static void endSanity(){
			System.out.println("\n::::::::     :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  ");
			System.out.println(":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: ");
			System.out.println("+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ ");
			System.out.println(":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  ");
			System.out.println("+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ ");
			System.out.println("#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# ");
			System.out.println(" ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### ");
			
			System.out.println("\nYou have turned insane. Probably the horrors you saw during the voyage were too much for you.");
			System.out.println("Noone knows what happens after this point, but your mission just failed. You lost your mind and the game.");
			System.out.println(Character.name+" survived "+Game.days+" days before going crazy..");
			
			System.out.println("\n                    `'-._                    ");
			System.out.println("                      `. '-._                ");
			System.out.println("                        T.   '-.             ");
			System.out.println("                         $$p.   '-.          ");
			System.out.println("                         $$$$b.    `,        ");
			System.out.println("                      .g$$$$$$$b    ;        ");
			System.out.println("                    .d$$$$$$$$$$;   ;        ");
			System.out.println("                 __d$$$$$$P''^T$$   :        ");
			System.out.println("               .d$$$$P^^''___       :        ");
			System.out.println("              d$P'__..gg$$$$$$$$$$; ;        ");
			System.out.println("             d$$ :$$$$$$$$$$$$$$$$;  ;       ");
			System.out.println("            :$$; $$$$$$$$$$$$$$$$P  :$       ");
			System.out.println("            $$$  $$$$$$$$$$$$$$$$b  $$       ");
			System.out.println("           :$$$ :$$$$$$$$$$$$$$$$$; $$;      ");
			System.out.println("           $$$; $$$$$$$$$$$$$$$$$$; $$;      ");
			System.out.println("          :$$$  $$$$$$$$$^$$$$$$$$$ :$$      ");
			System.out.println("          $$$; :$$$p__gP' `Tp__g$$$ :$$      ");
			System.out.println("         :$$$  $$P`T$P' .$. `T$P'T$; $$;     ");
			System.out.println("         $$$; :$$;     :P^T;     :$; $$;     ");
			System.out.println("        :$$$  $$$$-.           .-$$$ :$$     ");
			System.out.println("        $$$$ :$$$$;     T$P   / :$$$  $$     ");
			System.out.println("       :$$$; $$$$$$  ; b:$;d :  $$$$; $$;    ");
			System.out.println("       $$$$; $$$$$$; : T T T ; :$$$$$ :$$    ");
			System.out.println("    .g$$$$$  :$$$$$$  ;' | ':  $$$$$$  T$b   ");
			System.out.println(" .g$$$$$$$$   $$$$$$b :     ; d$$$$$;   `Tb  ");
			System.out.println(":$$$$$$$$$;   :$$$$$$$;     :$$$$$$P         ");
			System.out.println(":$$$$$$$$$;    T$$$$$$$p._.g$$$$$$P         ;");
			System.out.println("$$$P^^T$$$$p.   `T$$$$$$$$$$$$$$P'     _/`.: ");
			System.out.println("       `T$$$$$b.  `T$$$$$$$$$$P'    .g$P   ; ");
			System.out.println("         `T$$$$$b.   '^T$$$$'     d$P'       ");
			System.out.println("      Produced by Event Horizon Studios      ");
			System.out.println("             '^T$$$$b.        .g$P'          ");
			System.out.println("                '^T$$$b    .g$P^'            ");
			System.out.println("                   '^T$b.g$P^'               ");
			System.out.println("                      '^$^''                 ");
		}


		
}
