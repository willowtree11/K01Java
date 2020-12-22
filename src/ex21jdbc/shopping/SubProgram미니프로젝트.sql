/*
#==���� ���θ� �����==#

-���̺� ����
��ǰ�ڵ���� : sh_product_code
    ----------------------------
    ��ǰ�ڵ�(PK)	p_code
    ī�װ���  	category_name
    ----------------------------   	 
��ǰ���� : sh_goods
    ----------------------------
    �Ϸù�ȣ(PK)	g_idx
    ��ǰ��      	goods_name
    ��ǰ����    	goods_price
    �����      	regidate
    ��ǰ�ڵ�(FK)	p_code
    ----------------------------   	 
��ǰ������ �α� : sh_goods_log
    ----------------------------
    �Ϸù�ȣ(PK)	log_idx
    ��ǰ��      	goods_name
    ��ǰ�Ϸù�ȣ	goods_idx
    �α׾׼�    	p_action  
        -> �Է½� : ��Insert�� , ������ : ��Delete�� �Է�
    ----------------------------   
*/
--��ǰ�ڵ���� : sh_product_code
create table sh_product_code
(
    p_code number primary key,
    category_name varchar2(50) not null
);
desc sh_product_code;

--��ǰ���� : sh_goods
create table sh_goods
(
    g_idx number primary key,
    goods_name varchar2(100) not null,
    goods_price number not null,
    regidate date default sysdate,
    p_code number not null, 
    
    foreign key (p_code)
        references sh_product_code(p_code)
);
desc sh_goods;

-- ��ǰ�����ͷα� : sh_goods_log
create table sh_goods_log
(
    log_idx number primary key,
    goods_name varchar2(100) not null,
    goods_idx number not null,
    p_action char(6) not null
);
desc sh_goods_log;

/*
-�⺻Ű, �ܷ�Ű, ������ ����
	: �� 3�� ���̺��� PK�� ����� �������� �����Ѵ�.
	��ǰ�ڵ���� -> product_code_seq
	��ǰ���� -> goods_seq
	��ǰ�����ͷα� -> goods_log_seq
    
	���Է��Ŀ��� �ݵ�� commit; �Ѵ�.
*/
create sequence product_code_seq
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
create sequence goods_seq
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
create sequence goods_log_seq
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
/*
-������ �Է�
	: �Է½ÿ��� �������� �̿��Ͽ� "��������.nextval"��
	�Է��ؾ� �Ѵ�.
  ��ǰ�ڵ� 3���Է�
  ��ǰ 5�� �Է�
  ��ǰ�����ͷα� ���̺��� �Է����� �ʴ´�.
���Է½ÿ��� ���� �Է����� ���� ������ ���� ä���
*/
insert into sh_product_code values (1, '������ǰ');
insert into sh_product_code 
    values (product_code_seq.nextval, '��ǻ��');
insert into sh_product_code
    values (product_code_seq.nextval, '����');
--������Ȯ��
select * from sh_product_code;

--��ǰ���̺� �Է�
insert into sh_goods values (1, 'LG������TV', 1800000, sysdate, 1);
insert into sh_goods values (goods_seq.nextval, '�Ｚ��Ʈ��', 1200000, sysdate, 2);
insert into sh_goods values (goods_seq.nextval, 'Java������', 15000, sysdate, 3);
insert into sh_goods values (goods_seq.nextval, '�κ�û�ұ�', 450000, sysdate, 1);
insert into sh_goods values (goods_seq.nextval, 'Dell����ũž', 700000, sysdate, 2);

insert into sh_goods values 
    (goods_seq.nextval, 'DSLRī�޶�', 900000, sysdate, 4);/*
        ���Ἲ �������� ���� : �θ�Ű�� ��� �Է¾ȵ�
    */
    
--������Ȯ��
select * from sh_goods;

commit;

/*
-JDBC���α׷� �ۼ�
  : �Է�, ����, ����, ��ȸ�� �� �� �ִ� java���α׷��� �ۼ��Ͻÿ�.
 
  �Է� : PreparedStatement��ü�� ����Ͽ� �ۼ��Ѵ�.
  ����,���� : ���ν��� �ۼ��� CallableStatement��ü�� ����Ͽ�
          	�ۼ��Ѵ�.
  ��ȸ : Statement��ü�� ����Ͽ� �ۼ��Ѵ�.
 
  ���� 4������ ��ǰ�������̺�(goods)�� ���ؼ��� �ۼ��Ѵ�.
  ��ǰ�ڵ�� DB���� ���� �Է�/��ȸ�Ѵ�.
*/

/*
1.��ǰ�Է�
    -PreparedStatement��ü�� ����Ͽ� �ۼ��Ѵ�.
    -Ŭ������ : ex20jdbc.shopping.InsertShop
    -��ǰ��, ��ǰ����, ��ǰ�ڵ带 scanValue() �޼ҵ�� �Է¹޾� ����Ѵ�. 
    -�Է��� �Ϸ�Ǹ� �Էµ� ���� ������ ��ȯ�Ͽ� ����Ѵ�. 
*/
--Eclipse���� �ۼ�

/*
2.��ǰ��ȸ
    -Statement��ü�� ����Ͽ� �ۼ��Ѵ�.
    -�˻��� ��ǰ���� �Է��Ͽ� �ش����ǿ� �´� ���ڵ常 ����Ѵ�. 
    -like �� ����ؾ� �Ѵ�.
    -����׸� : �Ϸù�ȣ, ��ǰ��, ����, �����, ��ǰ�ڵ�
    -��, ������� 0000-00-00 00:00 ���·� ����ؾ� �Ѵ�.
        ��ǰ������ ���ڸ����� �ĸ��� ����ش�.
*/
--Eclipse���� �ۼ�
--��ǰ��ȸ�� ������
SELECT g_idx, goods_name, 
to_char(goods_price,'9,999,000'), to_char(regidate,'yyyy-mm-dd hh:mi'), p_code
FROM sh_goods WHERE 1=1;


/*
3.��ǰ����,����
    -���ν��� �ۼ��� CallableStatement��ü�� ����Ͽ� ȣ���ϵ��� �Ѵ�. 
    -��ǰ����
        ���ν����� : ShopUpdateGoods
        In�Ķ���� : ��ǰ��, ����, ��ǰ�ڵ�, ������ ��ǰ�� �Ϸù�ȣ
        Out�Ķ���� : ���ڵ� ���� ���(1 Ȥ�� 0)
        ȣ���� JavaŬ���� : UpdateShop
    -��ǰ����
        ���ν����� : ShopDeleteGoods
        In�Ķ���� : ������ ��ǰ�� �Ϸù�ȣ
        Out�Ķ���� : ���ڵ� ���� ���(1 Ȥ�� 0)
        ȣ���� JavaŬ���� : DeleteShop
*/
--��ǰ ���� ���ν��� ����
create or replace procedure ShopUpdateGoods (
        g_name in varchar2,     --��ǰ��
        g_price in number,      --��ǰ����
        g_code in number,       --��ǰ�ڵ�
        goods_idx in number,    --������ ��ǰ�� �Ϸù�ȣ
        returnVal out number    --���ڵ� ���� ���
    )
is
begin
    update sh_goods
    set goods_name = g_name,
        goods_price = g_price,
        p_code = g_code
    where
        g_idx = goods_idx;
    
    if SQL%Found then
        --����� ������ �Ǿ��ٸ� ������ ���� ���� ��ȯ
        returnVal := SQL%RowCount;
        commit;
    else
        --������ �����ߴٸ� 0�� ��ȯ
        returnVal := 0;
    end if;
end;
/
--���ν��� ����
var retVal number;
execute ShopUpdateGoods('Memory¯',50000,1,7,:retVal);
print retVal;


--��ǰ ���� ���ν��� ����
create or replace procedure ShopDeleteGoods (
        goods_idx in number,    --������ ��ǰ�� �Ϸù�ȣ
        returnVal out number    --���ڵ� ���� ���
    )
is
begin
    delete from sh_goods
    where
        g_idx = goods_idx;
    
    if SQL%Found then
        --����� ������ �Ǿ��ٸ� ������ ���� ���� ��ȯ
        returnVal := SQL%RowCount;
        commit;
    else
        --������ �����ߴٸ� 0�� ��ȯ
        returnVal := 0;
    end if;
end;
/
--���ν��� ���� ����
var retVal number;
execute ShopDeleteGoods(7,:retVal);
print retVal;


/*
8. Ʈ���� ����
  : ��ǰ���� ���̺� �����Ͱ� �Է�/���� �Ǿ����� 
  �α����̺�[sh_goods_log]�� ������ ������ �ϴ� Ʈ���Ÿ� �ۼ��Ͻÿ�. 
  ������Ʈ�� �����Ѵ�.

Ʈ���Ÿ� : shop_log_trigger

��ǰ�Է½� : Insert
��ǰ������ : Delete
*/
set serveroutput on;

create or replace trigger shop_log_trigger
    after 
    insert or delete /* 2���̻��� �̺�Ʈ�� �����ϴ� 
                Ʈ���Ÿ� ���鶧 or�� ����Ѵ�. */
    on sh_goods
    for each row /* �� ���� Ʈ���ŷ� �����Ҷ� ��� */
begin
    /* ����� Ʈ���ſ����� :new, :old�� ���� �ӽ����̺��� 
    ����Ҽ� �ִ�. */
    if Inserting then
        
        dbms_output.put_line('��ǰ�Է�');
        insert into sh_goods_log
        values (
            goods_log_seq.nextval,
            :new.goods_name,
            :new.g_idx,
            'Insert'
        );
    
    elsif Deleting then
        
        dbms_output.put_line('��ǰ����');
        insert into sh_goods_log
        values (
            goods_log_seq.nextval,
            :old.goods_name,
            :old.g_idx,
            'Delete'
        );
        
    end if;
end;
/

insert into sh_goods values 
    (goods_seq.nextval, '�����', 900000, sysdate, 1);

select * from sh_goods_log;
delete from sh_goods where g_idx=8;
select * from sh_goods_log;
delete from sh_goods;
select * from sh_goods_log;

