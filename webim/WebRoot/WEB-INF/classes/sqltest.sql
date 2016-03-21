insert into im_user(webim_user_id,webim_user_name,webim_user_password) 
values("1001","Ð¡ºì","123456");

insert into im_user(webim_groupset_id,webim_groupset_name,webim_groupset_nums) 
values("",#{friendId},#{friendSetId});

select u.webim_user_id, u.webim_user_name, u.webim_user_face,
f.webim_friendset_id, f.webim_friendset_name
from  im_user, 
select webim_friend_id,webim_friendset_id from im_user_friend

select webim_friendset_id,webim_friendset_name,webim_friendset_nums from im_friendset
where webim_friendset_id 
in(select webim_friendset_id from im_user_friend where webim_user_id='2b002ee1137048a5815cbbb57638736d')

select webim_user_id,webim_user_name,webim_user_password,webim_user_face
from im_user 
where 
webim_user_id
in(select webim_friend_id 
from im_user_friend 
where 
webim_friendset_id = '1f5f005d7bbb433da81d5dded0ea28f6' 
and 
webim_user_id = '2b002ee1137048a5815cbbb57638736d')


select 
webim_user_id as id,
webim_user_name as name,
webim_user_password as userPassword,
webim_user_face as face
from im_user
where webim_user_name = 'Ê®Î²°Í'

select 
webim_groupset_id,
webim_groupset_name,
webim_groupset_nums
from 
im_groupset
where 
webim_groupset_id 
in(
select 
webim_groupset_id
from im_user_group
where webim_user_id = '31169b16459547bca6cd1c71f02334a7'
)

select 
webim_group_id,
webim_group_name,
webim_group_face
from im_group
where 
webim_group_id
in
(
select 
webim_group_id
from im_user_group
where 
webim_groupset_id = '48aa18ad39cd4358b488ce787ac8401a'
and
webim_user_id = '31169b16459547bca6cd1c71f02334a7'
)

select 
webim_user_id as id,
webim_user_name as name,
webim_user_face as face
from im_user
where webim_user_id
in
(
select 
webim_user_id
from im_user_group
where 
webim_group_id = '232dd2c0c5b046b9819eac447022c76b'
)