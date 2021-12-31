execute at @e[name="west"] run particle cloud ~ ~ ~ 0 10 10 0.0 100 force
execute at @e[name="west"] run fill ~ ~-10 ~-10 ~ ~10 ~10 glass
execute at @e[name="west"] run tp @e[name="west"] ~-0.1 ~ ~

execute at @e[name="south"] run particle cloud ~ ~ ~ 10 10 0 0.0 100 force
execute at @e[name="west"] run fill ~ ~-10 ~-10 ~ ~10 ~10 glass
execute at @e[name="south"] run tp @e[name="south"] ~ ~ ~0.1

execute at @e[name="north"] run particle cloud ~ ~ ~ -10 10 0 0.0 100 force
execute at @e[name="west"] run fill ~ ~-10 ~-10 ~ ~10 ~10 glass
execute at @e[name="north"] run tp @e[name="north"] ~ ~ ~-0.1

execute at @e[name="east"] run particle cloud ~ ~ ~ 0 10 -10 0.0 100 force
execute at @e[name="west"] run fill ~ ~-10 ~-10 ~ ~10 ~10 glass
execute at @e[name="east"] run tp @e[name="east"] ~0.1 ~ ~