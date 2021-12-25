execute at @e[name="west"] run particle cloud ~ ~ ~ 0 10 10 0.0 100 force
execute at @e[name="west"] run tp @e[name="west"] ~-1 ~ ~
execute at @e[name="west"] run fill ~ ~-10 ~-10 ~ ~10 ~10 air replace #vlwml:belupacito_breakable

execute at @e[name="south"] run particle cloud ~ ~ ~ 10 10 0 0.0 100 force
execute at @e[name="south"] run tp @e[name="south"] ~ ~ ~1
execute at @e[name="south"] run fill ~-10 ~-10 ~ ~10 ~10 ~ air replace #vlwml:belupacito_breakable

execute at @e[name="north"] run particle cloud ~ ~ ~ -10 10 0 0.0 100 force
execute at @e[name="north"] run tp @e[name="north"] ~ ~ ~-1
execute at @e[name="north"] run fill ~10 ~-10 ~ ~-10 ~10 ~ air replace #vlwml:belupacito_breakable

execute at @e[name="east"] run particle cloud ~ ~ ~ 0 10 -10 0.0 100 force
execute at @e[name="east"] run tp @e[name="east"] ~1 ~ ~
execute at @e[name="east"] run fill ~ ~-10 ~10 ~ ~10 ~-10 air replace #vlwml:belupacito_breakable