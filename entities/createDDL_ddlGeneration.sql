CREATE TABLE positron.t_object (id INTEGER NOT NULL, DTYPE VARCHAR(31), name VARCHAR(255), PRIMARY KEY (id))
CREATE TABLE positron.t_building (id INTEGER NOT NULL, energy INTEGER, energy_max INTEGER, level INTEGER, lifetime INTEGER, radius INTEGER, portal_id INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_portal (portal_id INTEGER NOT NULL, latitude FLOAT, longitude FLOAT, radius INTEGER, team_fk INTEGER, PRIMARY KEY (portal_id))
CREATE TABLE positron.t_field (field_id INTEGER NOT NULL, territory_fk INTEGER, PRIMARY KEY (field_id))
CREATE TABLE positron.t_player (id INTEGER NOT NULL, bag_size INTEGER, email VARCHAR(255), energy INTEGER, energy_max INTEGER, mLatitude FLOAT, longitude FLOAT, nickname VARCHAR(255), xp INTEGER, team INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_key (id INTEGER NOT NULL, portal_fk INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_consumable (id INTEGER NOT NULL, rarity INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_resonator (id INTEGER NOT NULL, owner_fk INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_link (link_id INTEGER NOT NULL, field_fk INTEGER, PRIMARY KEY (link_id))
CREATE TABLE positron.t_team (id INTEGER NOT NULL, color VARCHAR(255), PRIMARY KEY (id))
CREATE TABLE positron.t_territory (territory_id INTEGER NOT NULL, PRIMARY KEY (territory_id))
CREATE TABLE positron.t_skill (id INTEGER NOT NULL, cost INTEGER, level INTEGER, name VARCHAR(255), type VARCHAR(255), PRIMARY KEY (id))
CREATE TABLE positron.t_turret (id INTEGER NOT NULL, damage INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_shield (id INTEGER NOT NULL, defenseBonus INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_multiHack (id INTEGER NOT NULL, hackBonus INTEGER, PRIMARY KEY (id))
CREATE TABLE positron.t_linkImprovement (id INTEGER NOT NULL, rangeBonus FLOAT, PRIMARY KEY (id))
CREATE TABLE positron.t_stats_attacked (MID INTEGER NOT NULL, DTYPE VARCHAR(31), MCPT INTEGER, attacker INTEGER, owner INTEGER, PRIMARY KEY (MID))
CREATE TABLE positron.t_stats_building_attacked (MID INTEGER NOT NULL, building INTEGER, MRESONATOR_id INTEGER, PRIMARY KEY (MID))
CREATE TABLE positron.t_stats_player (MID INTEGER NOT NULL, MPLAYER_id INTEGER, PRIMARY KEY (MID))
CREATE TABLE positron.t_portal_link (portal_fk INTEGER NOT NULL, link_fk INTEGER NOT NULL, PRIMARY KEY (portal_fk, link_fk))
CREATE TABLE positron.t_player_t_object (CPlayerEntity_id INTEGER NOT NULL, mObjects_id INTEGER NOT NULL, PRIMARY KEY (CPlayerEntity_id, mObjects_id))
CREATE TABLE positron.t_player_t_skill (CPlayerEntity_id INTEGER NOT NULL, mSkills_id INTEGER NOT NULL, PRIMARY KEY (CPlayerEntity_id, mSkills_id))
CREATE TABLE positron.t_stats_player_t_building (CStatsPlayer_MID INTEGER NOT NULL, mBuildingsDestroyed_id INTEGER NOT NULL, mBuildingsUsed_id INTEGER NOT NULL, PRIMARY KEY (CStatsPlayer_MID, mBuildingsDestroyed_id, mBuildingsUsed_id))
CREATE TABLE positron.t_stats_player_t_consumable (CStatsPlayer_MID INTEGER NOT NULL, mConsumablesUsed_id INTEGER NOT NULL, PRIMARY KEY (CStatsPlayer_MID, mConsumablesUsed_id))
CREATE TABLE positron.t_stats_player_t_key (CStatsPlayer_MID INTEGER NOT NULL, mKeysUSed_id INTEGER NOT NULL, PRIMARY KEY (CStatsPlayer_MID, mKeysUSed_id))
CREATE TABLE positron.t_stats_player_t_resonator (CStatsPlayer_MID INTEGER NOT NULL, mResonatorsBuilt_id INTEGER NOT NULL, mResonatorsDestroyed_id INTEGER NOT NULL, PRIMARY KEY (CStatsPlayer_MID, mResonatorsBuilt_id, mResonatorsDestroyed_id))
ALTER TABLE positron.t_building ADD CONSTRAINT FK_t_building_portal_id FOREIGN KEY (portal_id) REFERENCES positron.t_portal (portal_id)
ALTER TABLE positron.t_building ADD CONSTRAINT FK_t_building_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_portal ADD CONSTRAINT FK_t_portal_team_fk FOREIGN KEY (team_fk) REFERENCES positron.t_team (id)
ALTER TABLE positron.t_field ADD CONSTRAINT FK_t_field_territory_fk FOREIGN KEY (territory_fk) REFERENCES positron.t_territory (territory_id)
ALTER TABLE positron.t_player ADD CONSTRAINT FK_t_player_team FOREIGN KEY (team) REFERENCES positron.t_team (id)
ALTER TABLE positron.t_key ADD CONSTRAINT FK_t_key_portal_fk FOREIGN KEY (portal_fk) REFERENCES positron.t_portal (portal_id)
ALTER TABLE positron.t_key ADD CONSTRAINT FK_t_key_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_consumable ADD CONSTRAINT FK_t_consumable_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_resonator ADD CONSTRAINT FK_t_resonator_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_resonator ADD CONSTRAINT FK_t_resonator_owner_fk FOREIGN KEY (owner_fk) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_link ADD CONSTRAINT FK_t_link_field_fk FOREIGN KEY (field_fk) REFERENCES positron.t_field (field_id)
ALTER TABLE positron.t_turret ADD CONSTRAINT FK_t_turret_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_shield ADD CONSTRAINT FK_t_shield_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_multiHack ADD CONSTRAINT FK_t_multiHack_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_linkImprovement ADD CONSTRAINT FK_t_linkImprovement_id FOREIGN KEY (id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_attacked ADD CONSTRAINT FK_t_stats_attacked_attacker FOREIGN KEY (attacker) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_stats_attacked ADD CONSTRAINT FK_t_stats_attacked_owner FOREIGN KEY (owner) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_stats_building_attacked ADD CONSTRAINT FK_t_stats_building_attacked_MRESONATOR_id FOREIGN KEY (MRESONATOR_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_building_attacked ADD CONSTRAINT FK_t_stats_building_attacked_MID FOREIGN KEY (MID) REFERENCES positron.t_stats_attacked (MID)
ALTER TABLE positron.t_stats_building_attacked ADD CONSTRAINT FK_t_stats_building_attacked_building FOREIGN KEY (building) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player ADD CONSTRAINT FK_t_stats_player_MPLAYER_id FOREIGN KEY (MPLAYER_id) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_portal_link ADD CONSTRAINT FK_t_portal_link_portal_fk FOREIGN KEY (portal_fk) REFERENCES positron.t_portal (portal_id)
ALTER TABLE positron.t_portal_link ADD CONSTRAINT FK_t_portal_link_link_fk FOREIGN KEY (link_fk) REFERENCES positron.t_link (link_id)
ALTER TABLE positron.t_player_t_object ADD CONSTRAINT FK_t_player_t_object_CPlayerEntity_id FOREIGN KEY (CPlayerEntity_id) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_player_t_object ADD CONSTRAINT FK_t_player_t_object_mObjects_id FOREIGN KEY (mObjects_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_player_t_skill ADD CONSTRAINT FK_t_player_t_skill_CPlayerEntity_id FOREIGN KEY (CPlayerEntity_id) REFERENCES positron.t_player (id)
ALTER TABLE positron.t_player_t_skill ADD CONSTRAINT FK_t_player_t_skill_mSkills_id FOREIGN KEY (mSkills_id) REFERENCES positron.t_skill (id)
ALTER TABLE positron.t_stats_player_t_building ADD CONSTRAINT FK_t_stats_player_t_building_mBuildingsUsed_id FOREIGN KEY (mBuildingsUsed_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player_t_building ADD CONSTRAINT FK_t_stats_player_t_building_CStatsPlayer_MID FOREIGN KEY (CStatsPlayer_MID) REFERENCES positron.t_stats_player (MID)
ALTER TABLE positron.t_stats_player_t_building ADD CONSTRAINT FK_t_stats_player_t_building_mBuildingsDestroyed_id FOREIGN KEY (mBuildingsDestroyed_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player_t_consumable ADD CONSTRAINT FK_t_stats_player_t_consumable_mConsumablesUsed_id FOREIGN KEY (mConsumablesUsed_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player_t_consumable ADD CONSTRAINT FK_t_stats_player_t_consumable_CStatsPlayer_MID FOREIGN KEY (CStatsPlayer_MID) REFERENCES positron.t_stats_player (MID)
ALTER TABLE positron.t_stats_player_t_key ADD CONSTRAINT FK_t_stats_player_t_key_CStatsPlayer_MID FOREIGN KEY (CStatsPlayer_MID) REFERENCES positron.t_stats_player (MID)
ALTER TABLE positron.t_stats_player_t_key ADD CONSTRAINT FK_t_stats_player_t_key_mKeysUSed_id FOREIGN KEY (mKeysUSed_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player_t_resonator ADD CONSTRAINT FK_t_stats_player_t_resonator_mResonatorsBuilt_id FOREIGN KEY (mResonatorsBuilt_id) REFERENCES positron.t_object (id)
ALTER TABLE positron.t_stats_player_t_resonator ADD CONSTRAINT FK_t_stats_player_t_resonator_CStatsPlayer_MID FOREIGN KEY (CStatsPlayer_MID) REFERENCES positron.t_stats_player (MID)
ALTER TABLE positron.t_stats_player_t_resonator ADD CONSTRAINT FK_t_stats_player_t_resonator_mResonatorsDestroyed_id FOREIGN KEY (mResonatorsDestroyed_id) REFERENCES positron.t_object (id)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
