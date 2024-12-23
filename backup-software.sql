PGDMP     "    )            
    |            bd_software    14.5 (Debian 14.5-2)    14.5 (Debian 14.5-2)     -           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            .           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            /           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            0           1262    27197    bd_software    DATABASE     `   CREATE DATABASE bd_software WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE bd_software;
                postgres    false                        2615    27198    administracion    SCHEMA        CREATE SCHEMA administracion;
    DROP SCHEMA administracion;
                postgres    false                        2615    27199    general    SCHEMA        CREATE SCHEMA general;
    DROP SCHEMA general;
                postgres    false                        2615    27200    localizacion    SCHEMA        CREATE SCHEMA localizacion;
    DROP SCHEMA localizacion;
                postgres    false            �            1259    45515    cliente    TABLE        CREATE TABLE administracion.cliente (
    clie_id uuid DEFAULT gen_random_uuid() NOT NULL,
    clie_nombre character varying(150) NOT NULL,
    clie_email character varying(150) NOT NULL,
    clie_start_date date NOT NULL,
    clie_end_date date NOT NULL,
    clie_estado character varying(2) DEFAULT 'AC'::character varying NOT NULL,
    clie_shared_key character varying(15) NOT NULL,
    clie_phone character varying(10) NOT NULL,
    clie_fecha timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
 #   DROP TABLE administracion.cliente;
       administracion         heap    postgres    false    6            �            1259    27235    usuario    TABLE     �  CREATE TABLE administracion.usuario (
    usua_id uuid DEFAULT gen_random_uuid() NOT NULL,
    usua_username character varying(30) NOT NULL,
    usua_password character varying(100) NOT NULL,
    usua_email character varying(200) NOT NULL,
    usua_estado character varying(2) DEFAULT 'AC'::character varying NOT NULL,
    usua_fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usua_nombres character varying(150),
    usua_apellidos character varying(150)
);
 #   DROP TABLE administracion.usuario;
       administracion         heap    postgres    false    6            �            1259    27267    tipo_identificacion    TABLE     �  CREATE TABLE general.tipo_identificacion (
    tiid_id uuid DEFAULT gen_random_uuid() NOT NULL,
    tiid_prefijo character varying(3) NOT NULL,
    tiid_nombre character varying(100) NOT NULL,
    tiid_estado character varying(2) DEFAULT 'AC'::character varying NOT NULL,
    tiid_fecha timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    tiid_codigo_ws_multiburo smallint
);
 (   DROP TABLE general.tipo_identificacion;
       general         heap    postgres    false    7            �            1259    27291    ciudad    TABLE     �  CREATE TABLE localizacion.ciudad (
    ciud_id uuid DEFAULT gen_random_uuid() NOT NULL,
    ciud_nombre character varying(300) NOT NULL,
    depa_id uuid NOT NULL,
    ciud_fecha timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    ciud_update timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    ciud_estado character varying(2) DEFAULT 'AC'::character varying NOT NULL
);
     DROP TABLE localizacion.ciudad;
       localizacion         heap    postgres    false    8            �            1259    27298    departamento    TABLE     �  CREATE TABLE localizacion.departamento (
    depa_id uuid DEFAULT gen_random_uuid() NOT NULL,
    depa_nombre character varying(200) NOT NULL,
    pais_id uuid NOT NULL,
    depa_fecha timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    depa_update timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    depa_estado character varying DEFAULT 'AC'::character varying NOT NULL
);
 &   DROP TABLE localizacion.departamento;
       localizacion         heap    postgres    false    8            �            1259    27307    pais    TABLE     �  CREATE TABLE localizacion.pais (
    pais_id uuid DEFAULT gen_random_uuid() NOT NULL,
    pais_iso character varying(3) NOT NULL,
    pais_nombre character varying(200) NOT NULL,
    pais_fecha timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    pais_update timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    pais_estado character varying(2) DEFAULT 'AC'::character varying NOT NULL
);
    DROP TABLE localizacion.pais;
       localizacion         heap    postgres    false    8            *          0    45515    cliente 
   TABLE DATA           �   COPY administracion.cliente (clie_id, clie_nombre, clie_email, clie_start_date, clie_end_date, clie_estado, clie_shared_key, clie_phone, clie_fecha) FROM stdin;
    administracion          postgres    false    217   8%       %          0    27235    usuario 
   TABLE DATA           �   COPY administracion.usuario (usua_id, usua_username, usua_password, usua_email, usua_estado, usua_fecha, usua_nombres, usua_apellidos) FROM stdin;
    administracion          postgres    false    212   )&       &          0    27267    tipo_identificacion 
   TABLE DATA           �   COPY general.tipo_identificacion (tiid_id, tiid_prefijo, tiid_nombre, tiid_estado, tiid_fecha, tiid_codigo_ws_multiburo) FROM stdin;
    general          postgres    false    213   �&       '          0    27291    ciudad 
   TABLE DATA           k   COPY localizacion.ciudad (ciud_id, ciud_nombre, depa_id, ciud_fecha, ciud_update, ciud_estado) FROM stdin;
    localizacion          postgres    false    214   �(       (          0    27298    departamento 
   TABLE DATA           q   COPY localizacion.departamento (depa_id, depa_nombre, pais_id, depa_fecha, depa_update, depa_estado) FROM stdin;
    localizacion          postgres    false    215   ر       )          0    27307    pais 
   TABLE DATA           j   COPY localizacion.pais (pais_id, pais_iso, pais_nombre, pais_fecha, pais_update, pais_estado) FROM stdin;
    localizacion          postgres    false    216   #�       �           2606    45522    cliente cliente_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY administracion.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (clie_id);
 F   ALTER TABLE ONLY administracion.cliente DROP CONSTRAINT cliente_pkey;
       administracion            postgres    false    217            �           2606    27525    usuario usuario_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY administracion.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usua_id);
 F   ALTER TABLE ONLY administracion.usuario DROP CONSTRAINT usuario_pkey;
       administracion            postgres    false    212            �           2606    27535 ,   tipo_identificacion tipo_identificacion_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY general.tipo_identificacion
    ADD CONSTRAINT tipo_identificacion_pkey PRIMARY KEY (tiid_id);
 W   ALTER TABLE ONLY general.tipo_identificacion DROP CONSTRAINT tipo_identificacion_pkey;
       general            postgres    false    213            �           2606    27543    ciudad city_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY localizacion.ciudad
    ADD CONSTRAINT city_pkey PRIMARY KEY (ciud_id);
 @   ALTER TABLE ONLY localizacion.ciudad DROP CONSTRAINT city_pkey;
       localizacion            postgres    false    214            �           2606    27545    pais country_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY localizacion.pais
    ADD CONSTRAINT country_pkey PRIMARY KEY (pais_id);
 A   ALTER TABLE ONLY localizacion.pais DROP CONSTRAINT country_pkey;
       localizacion            postgres    false    216            �           2606    27547    departamento state_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY localizacion.departamento
    ADD CONSTRAINT state_pkey PRIMARY KEY (depa_id);
 G   ALTER TABLE ONLY localizacion.departamento DROP CONSTRAINT state_pkey;
       localizacion            postgres    false    215            �           2606    27620    ciudad city_state_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY localizacion.ciudad
    ADD CONSTRAINT city_state_id_fkey FOREIGN KEY (depa_id) REFERENCES localizacion.departamento(depa_id);
 I   ALTER TABLE ONLY localizacion.ciudad DROP CONSTRAINT city_state_id_fkey;
       localizacion          postgres    false    214    215    4243            �           2606    27625    departamento state_coun_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY localizacion.departamento
    ADD CONSTRAINT state_coun_id_fkey FOREIGN KEY (pais_id) REFERENCES localizacion.pais(pais_id);
 O   ALTER TABLE ONLY localizacion.departamento DROP CONSTRAINT state_coun_id_fkey;
       localizacion          postgres    false    216    215    4245            *   �   x�m��J�@��ӧ�R�Lf&ӓ"��^�f�.l]P|�[�,��A��G�f�Z�2�ڰ��\�(k��}����iC�����	���C�^T�T�Ե��msI6��6g��bY�����l[�;������������5�j�QҕFҁ�GR��$6��L F�������k���^?�)��gR�p7i?�o�\�^��!qϚ��|�<�]�}��_s      %   �   x�=�I�0 �u9���ju�b5qB�7���8���L�&����q_����@qsQV
�;b���a+	�8D:�v+�v��8��t	���p��O}{�綷�����}{�%�V��d��e�L��dFA��B��@��$Jr��h�m[c}i��{�Ys�{pfA| N<[      &   �  x���=n1�k�)t�Y9�l�.���2͐k8R �A��"U����2�p$;���{+6�"D%��H jPk�-����|cn�Q>Og5�ơs0~Y�A� .�go]H�O찓-=t�u�{�"J��օ�\]��c}����qs��|�ý���|�`y3��O�g��/�4��u��T?v(�F@��{"�ə�|m����Ӄ��?��pa�P�S�L|�{i�T���F'�lgq�f�7���f�F���U�������aJ݇�K� m�2d4�O-��Gs7�̝���,����&���o���9at�"�y*�S�c�,���!X��F���Tm-4��i���׍|^8�9#�xqة�lt	kO�!a �=RK�V[6�Cq�����8_և��_�P��"�r@�+Hq
X(�Fd�`�������~�i�/��M�i�~N¼      '      x���ͮ��q5<��Up�����H�RlX2#)�Yuw5��}Φ�9GxŻ��ςw���z�؊�R�V�D�󔻫���Z��wu��=��Yn?c�!j�͝^ɭ_��S��6olv��ޒ�eU3jj��\r�'o�3��^��K�~i�/�k�c��ϯ�|�Bh-����|����Y)�b����^.�-��1g���TM���3*�U+�8�sw��Y��M�V��}X%t#C��!ԒJ��=��y�A+�>��e,7l�`j�AQF�mڤ�Ҡ��&�Z�\Zf&��8�5����򩺩[v�������=�68�cĺ��M+����bSs��^��C?�e�W�s�h��%�Nc�e�V��a�\8�z���cϦ�[���Lw��G1���Z�1��i�������щN�-�Y���P'�̔���`a��=�I��M�+4�2+fB�
c�����˔=T[����xSb�8f3�zX�Z�p���ɝ�?�Y�,��0�	^=�Q��B�&k�ϡ�M����z۵P��ڌ]���Z�I��۪:�Wka�Mb���ͦ�X�S�E0���MY>8�eu�����q���A&N��8,p ��mJjmj���6��f� <�
�c6R}7��.v�� J{��/~�/�>��M.{�*�5�,Sl��o�����"% K�������]^�������n1�kB�[�8?�T�\�f�<�ZfK0�i��.@`����ߚi �T5)�����!ɽ�挘p���Ip���JE�D�4cʂ��U<���^o�M�|�YR$�����i	8uYՆ>q0O���z��\��E�^E��.�Qs��g�0�~�q���ٶ���M�BKAT��MW�\�6�z؄�~�2m D-��b*��	�1 �\߁$tٴu�UZ�,'� ���di���}X��+�z�{��5+�D� 4����iW�p�ӯ��w�xބ
lT/v:�R�7� ��a�Ee!��x�u�o�cSH���6��%ּY��&�������ˋW���'�ĸ	�2aF�`������D$XW-z���=�WGR�z�k�zAI 	��8l]� }���۞m�.|C�q�?��'@e֐��@	�_�?��v;o�%?q�֚�����B����G�6}w~+�ȓ����s�ظ���������|��.���d] HH��#$u`�Z�c�)6��������M�i��OF�����hz�
�P���3`�M��kՅ�4�%��� &��Eb�`	�0�6��h
�.�)���J6�&;@�ת�Mw��z��_���&�r�փ�B� �-����=���q���?7�R�@�� �t`�����N�ƂMظ'�sy��J��8b�X�>�D��x�Z�U���=M��o���	�=Li{�hO��n:[z��ҞG�����̰�
�����:@~W��G�v�� �슑���g�h
������E}���;����ݶ�n��f���-N�����$A @'��7���i�MN�Qj�#͎�p8i���x-��:�=Or�vO�n��H1��?8P\Ф�J���X��"b��0�1[�VC6�PԬ�^����R��8�Vo�P�tب
��|'��=�f��т���;y�Z����u?5X�b���-�`����r�A�~ ��\v�)嚺�����6������zs�ܕԦ�S��?��x#���m��[��o��n#zvnf�ۈ(�3E��ɚ�D�k�q�o&ϛ�ցe��|���o��?GOK��3�	@��s�kcU6ۆA6�S�#0�s���@D)��&,$�Xf�^��'>X��GmS��6XP�a�|��[M'~�� �o����3���^ݓ]���,����:��%���λ|��	��� �аm>Г����F �Қm0�q�W[��~Ib�(p���/� r����g}
�O��M2�Nk ?�]�`�����o��"�9�#��O5��e�y�Q�Ҝ����Vr�#�n�_� *u�O�f�F�)��O����{��!��4���%�ke���0���wz���GV���G�� |�ӌ�T��-v�ӛ'��mR�'4yx��
h��MM��N��Fp�F��/^�k{������FxU[�|�\&�	�"�~?�� ��]kQ����"e, 7����x��j����n����rT���;V�a2�d��kݶ���V=}�w:w]���._�k�@��f�t�
�2|������t��Wέ�fl?�"��Ɩ�c��MN_�G���u����VaqI   �)k�R�X��(�uɦ��ij�Q_��(/s����L����ʐ����M������	>�<�څ �{�_���7}`��k�?<m�)q�*11���ݪ3}-k�H�.m.�^v�!�gN�_���|Z�?0�G�J�C�+7sP�h]$�d��KgXKJ<���.?3�d�����j\;�n���:g��i�>���8?����S�r���}3�j�YX�$r]��ç��~�����n�U��Յ
�$��)���h������l��A���d.��/?�����j;6��;<�e���f��T�|��n��n�3���iv愔�Ly�Č_�T㝛�z>�<;���{\�\F� �VRa�B���fp5�<�٢7:o�c;�/>;_���-���&V@=�e�,>_������7E,b���}����\y�-:�i���,���*��a��D�D� �62ϋ2��&�ʀ��VMU����s��O�d��oR���I����M�<��L_���?�1
I1?��T`Y :�l���H�(/�{!?��৚���
p�T���#��'�{,��v|4��k_��a�Q��z0�����Rf(3/��u���^��?���'/��c��˱L� �T�"m,���tx���\��SMu�lڲ�A�a�4#�j�ZF=}�o���L(�S�tKs0@Y�/A�8Q�(Qö�� &��?������S �k� �e�����(�!G��*���N���XT슎0=��'w��d�'b�Wr��rs*����8�t��d����$~���=.$�= ��R��� 3�u5��"�y�s�j��
�Wiֲ6��*�}��=d�W:}u~<����]0��Cv�fu��l�����������s�U~�/H�@�f�TRt �!&U�s_6�`�ӭ�1g͖�B�Zx\�=�5�x��Kr'`���ϼN��y#�)�T��Ѓ�R���'��4t�M�#����W/�#�s!2���d@�\�yW��u��%��J��>�����,��!�7��CY)�l�dv���Ug�Hgޞ�ַ�s�9~r&�ݎ��Y��3`k��k�AN	��شk�X p����WxTo�$�6D�^,�������1�^	���@8�c�,˛��I �@�|wcb�N�.?�=�Z�
Λ���LL �95p_��&+�	knOw����`(�O0���bk�������^�w�"�+��Mì�q�Y�[���E��B,� �� �����Ņ�p�Y�*�'�@�s����?��^7A��{�y-���	g��I�Ą�	�^��hu����x/B�
�M���ȇ��p̏���/C�E�է`Ϗ�V��e�,��]��
�N����Iv�I5�N��ָDb�E5pI̍���o�����W�F-�@��23a�"R+K� �>��0����t�c���;.�xЦ���-�J-�������=ˊ�fy>��4�^�����֜M;�56O��xb���9���x��ĕ" �Q���I�b �X)Ŭ���Ј�eZ*�:�;��*'���<"b�b��D�s���`M��U����T�Sj�<���W�j}|w����25�@"HvqmM�-I�A���V;��ku�j���*�&�"��G��-]�׏��oO�Xֳ�0g���7(v�!+��%��cf��ԋ��{VkD0���sl����Ȗ�Q~������\��{��aD����&�a�+�Q�F?���ׇ�=v����T�k|c6>O�l��_Y_��    wO�'�-�>�D��5F�[�L���=!�8�*�ϰq�o;R@X�Bdu��	(�FgR��9�K,�����O
VŃ)e��X�1��8=�fPKȧ7r�����/7��Jvl`K $ )u��I/�L7m�v�zzs�~�g��/Nc��������(v������D���O������K��-2AM�pz�@�p�l�ש�=��=-%3�,�R>�ñ�p���[�����`M�"8�ub]�ݹ]:�a[,�g��da8��}��-�	N�z��4�2����7g��.���1��+)��|7�n�<JM��#8,C����FՔJ��ft�ܨ wM��3��a`�������ɡf��#���<���"�©՚}������N���^�1k�r� ���?�:��﵉��E��-	|�SXD<(oT�_m���Уn�ӗ *{�ݘC٬�7Y������SV��髧�]y���_��{$Z��
X�KXKE�ְN��p��t���lQ�����D�*n���HE�����׸A�8������V�5A����������/��E)�d͏~�`)��2��֬�|�fkQ���������pܚ�흏�;L[	�w�6&i8�wq����:� 龼��_�,U�U���VR��|���o .֪����l�'!�������7R��F��,���ܮ�_�9.+wUk���P٪�$���]q���)|���caU߳\u������`M�ݑń6���4��&� Ph�P��7���	ւD�%��ϕ����p��X��D�m�A�j[�t|z>� :�k��^U�孰5k�M>v_&v@R:x�wM�6�d?�I�1ؤ��؋��O���0�V��
�gO ����>�eGv���y<�=��rcai	�c�������B�/z���s[�Ϗ���#��
�]��Ѕ!H�I+��z��BB��V���*UcY�q�
l��;T~�[l����50����ީ���H���)ݚs��iݧOr�)�Kf)6�����΋I��.��4���HlD�a��o=/g=)p�`m&	'������7�L�r̽�QX�3g�$�\Qܒ����g���o�t~�3NauE�#��i�-�ζ
hޱ���y�=!xwZgB&��c��
G�F��ʲ��=�o9����O�_�(�ܥV�F�\,�G۶����|�)P����G�t��M�r��7|ǖ�F�q;?<�QRꋏ́~���'��kՙ�ْ�}�&��O.KϚ�v�) �����=-P�e��F�(�'��Q�����:o^�M�������aٓ�@T�0��6����5�e����!IpݳB�H��9�ϖ�2a>����k��/��y^�$ݪ1̀�(����1��T�*8�ѳI���g�v�9����<x0n�B��	Ǝ���s,y�;�~�E�]Ͳ��Ĕ�ϮI��99Z��sͯ8��"��o1���(��oHAl�MF��敞���v/�x��G�GaZa k�"[:{M�����,��M|��s�PT&|)��d�ɑ�<�֨�
��O�b^/hS:8��W,1\�`ŽzƲ�ki�\�]��Y�V�� �s7[d��Td�^��º�� ���o;\A�M�wq"C�Z�Q�1&p�1���H�D߇�P�qACb���YW�J���m�ǲ�-i1ô8�Vj��@x�w��мF������Z���{�g�]��H, Y���R�B�Z�6k�vݞ�ӿ>�޽���=�_W	�ft��U�\�dGlɳ���9�}���s�9(����M_��-�:q%-���]d�_>�An870�|��H�u���ZmE�H��_��Ώ{��,] ��Z�Ic���*@� 1�V��|w�]i��ZZ@8����O1aSk,> a�8N_�E�o��c��ri����e*R�QW4;,c�y�����^G�J�a�!-Z�4���(��].��±#Z��X����ĭ#װ��'a$�lЦ�������2����&�B�j�(��Yx?��&�,(� ��d�_�W<���uO�	�*b�59P�j�P��.��Ci�{wzyNS�Tg�k��k-V���G� ������K�QY��L��o����"���Ŵޝ��4�ĥ���6��2}�Eu4`w`��q"Q��z`[��Y������>��~�=���[�|�f�,ky����J	ܫ��[�]�"*���D�V���0!�i�{� �Bv�n�Y��G��1�����9��2������q�A@m�_�0�WR�4�+��K���~u�^Ƈ?n1(�4�Մ�B�ʫWXd�xҁ�c���a�i.�N�Z�G�`R\٭fg>�z�{��æmkKhh��3����![ĥ�Z(��y�����i�c����_�ڕѠ��m3u6�<�c�aOr����I����ȴ-,�y���J�����a�7�"��Y��W�m��;(/;c��Zo�����Uw��Hc�]MF2\����i���u�/(9��l!��tܷ53W�F�� �މ�&�U��,k�V���� �*PR�Qaև?æM����Ձ��!N���D)����i��+�06��&�jM�d��b���Y�a�+�A n�͓b��r�e����R�6�8��9�c���=:+q�:�/������Jn$K����]9��&�>yg8�[8��Ȝ���Eg I}�)(Q�"��ȱ��{o�=
��eDMP���z�wyRa�f��x�8�5���j�K��=���mO,�3��w��x���u�k��|�sv{~W�mc����7?9�f�OR�u�ܣ'}B��~�����{vm6ۦ��̾򮔢�&�2��/
�����w϶�U8r�s���!�u�ɐ�U�3d�[���65 KfWD���f2��J����}�!�!w��;X�D� �3]4��eɧ_����1)��ŧ�,���q1�i�;|ei���X����'˅�&�)���Hɭ�K�B���w�圉��Z�Ǣۊ)����m�O�7bH�6m�"ގ^p�Rz0��>L��	,|;�>�\o���ɐ1�#��+p �mi$���F��ӧ�r��)��4e��(��� ��i	���!�~��w��ڹ&��,�G���<����m	�c�i�M�6!g'��Z1� ���&ғ�c�c|�@H�~�^�,�����'��m*Ɖ�a��Vv���Ǉ?�����ԙ%qq�*-����&�M���M>$��c$Mpl&��y�c�t�1��IO��{}�MҎ�l
��;�8J�V�5]j%�ơbσ�>�uϹ=�.� �Q�V"���! 9��l����bMQ#�g����R'���1���x��6����z�,?7��#�$R���0�o#��ŧ�-�;[:R��"�V�5|���W�s��m�l!�l�۠"k�ht������Q��r�gq9���B�>�ySMD�ӓ�k�)$���/����y�H�)��GyG��6�.g�řJ9�h��������c�C�h�m�lůՎ4��ٴia����f*ϛ6
K�I�Sd��ʖ�7^��V���ۨX�vg��0�6=�!��(/����r�e݆� ���O�=���B�X4t�'7]"me�z�|t)�r���6�l�c����_�0_2�1ӻy:�4�E��{�Q�.p�2G�h��HA��N�?�m�~�w�R!B�#�.�K����&�r�O����͞�fe>m3>��?� D
%%�Z���ңm������8x����]�_���No>�Q��Y!(�&��١=G3��d$�`���ݦ۵�eE�Y��j�c���b�Ցj)��|�V�Mo��!I���V��fj��O�5�Y[lXt��'�t��
���p�Z2U=[�2.�ҙ`���&.�݀�tA�V#b�~�eM��Q�e�or�������(`��B�3���Z���"��ß7��u(��r�DF��zu F�-��}����
��؈��>�:H�~��ӛ��&�H�]K��;����3��g    ����A��8֍l�cU�bJL,�[�i��,�G�d���� ��v��>��9l��`!�dYύ�� s������Pv��y�9>�9 �@�!^G��0�RB������w�y[�DMp��}��כ⒄�[/ŝ(���I�YGA�.6pNeY:��J�M���������Y$��A�SaC��\��7���f���?�oΛΚ��i��yY�ڹ!HYy ����#w�jƆ�י�͙6G���F+�cˮ���2���$��'�d,�/H���2n#�:�Br\%��ù>��Y��hט bA�lY��h�],i��ۦ�0��ß�Qy�����%F�*8���B��4j�'�Mm��$�c��JR���*�۝�P��S�B}&�>������I/\�/uS�I�ٵi\�����(�?T�H�o���[�S�`�nq�孢;�o�J]�����h��v�]E�TqC-xJ��S��=���e#��k?����Q9�c����q}z�����!ʴڳ���y_^׮E#��YGχU�[#݉YK�VU��ΪML��6�������C{���
����"�-7a��Ź��R�z‼�o�Bg��z�t�a���vfk��B��"،]�ӝ�2���m��#k�_ʹ�5�n{.��\���7�m� �)*�(K�'3�D��`�o6a�T&N}`��{��a�8�u��V��4�k}��t �cF�Qe�^������}+۪�������K�/.P$IJ��#W�D�HL�iu�)�C�H���_ĵP�h�ٚ]���������Y�ш
h�LVc��;�A������� !�� 2n��Q��&���N_>=`�6Q�Q���֙�xle�~-�l-5g���Qnw,Y�UGђ��I����d�2�D�	�'���6u��l�&��w|ۡvj�'ņ5ב���s��M~��}C�-�R|P<C�1ͭQ��E�;z�nzoJ�`}3y�34i�-,YT��8,��v��O���x5whoƂ�]�Fr� �mZ�,z'c[�GT���������aj�W!��W�MWM��͓��,�4 !SC>>��o?��M7s	P#wG&2����7�((�7vQ��W��N6U�[]��M��ptIb�P���р��B��ᦄ~h'��IxEa8M�t��UBec9����:
+7���ʂᮙ���Ƞ9O���s从8nF��yE�i��ff�ԧ�3;���O��gӐL��f�ʡ��^`^�{�68���z��2�Zh�ƻ�.��!D�R��-[*��fW�d��q������2����T*��m_��65%G�	�Iܕ5o3E�(���቏��_��N榳6kt�O3;�'��ږC�ϭJVL8����M�
���ki�^�r��4��n����v�X���.l�S����.�@ "%�9��>��M�ȅaY}�89y#��jk��:��>��,-�48�0�X )��i�Fo�������� �k������Q��
i�c�d��E��H�[#;���op7���=l
đ��uU�>Vl��Lg}���-e�ڀ�R��ju����ӧ4Zg�,!�!��ŦٕC��Ꙝ��2i :�Q�����s���x�6�
g��j��Cۓ�N�C��$$�N��/2���{�)�g���:�P����4m����(����vD��B3&��*䙗�
�����{� �0�3��[L�?�&� �&��;�{ő�5S�����r��i��������Mu��U ����&��{���IrTN J��y��<ۧA^~�%�w����V�����ٴP*��u��|��$��� �Zj���o�a��7�9 ���a�M��c��i��E�79�����R�=zV�Q�< ��Y@��8}��`Β`c����T�A��4>�sƹ��z�i�pЖ"�#tS��'�o���4�u��XkzݴBNcꓰV�¢�n~��e���"�����J�[���Cq�"+�%r�:�R
�����?�/�=�pm0j�x3afdA.{�+�<R�h1D�+����yOH�*1z�,l5[���G��'-��	��F�=���ق��WX|0�;u=W&G�����Z����Z�E]�śm���2ůu�m���,�PH��|T1�MIa`d��Cq�����#{p��gڑ9�:#��>��&����޿#d����|��C9��k2Y��8�m��ߝx;VhI�����ˣ���ihV�[>�狀���$;����$%�խ�g���EC��P�U�������I'[r'j�耹kN�/��K?"v*X�hq �!SEY0hC��W��h��EB8Ā���s���ZWp���~�)|���Og����Z�[7�D�2;��_`�a�2����./^#�L;��Iܠ ǫsr�b_-�x-�;K%���"l1h��#��9E-;��)yo��G�(;����]FyX5���Pz.Nj�R`YR'���c��<}{�l1)X)6EvR��q&�{ԅ�A������1�j�IEr�2S-N�!��lB�Jr#Du�~������5d�ݣc3
b�)�s"�S���O�;�Ie��C8=�S��nfɓҼZ�>ϛ^6훓ދ"�xj�6!��Rts��Qz������>,q�>xQ�Y�2�9(r��[G}�6����~����^�l#���.&������D�R JG�����On�nOt v*Gh�Q,��=���9��vf֚]�K�%4��L��Hx)�M9 ��ZChH�gWL�f[p.c�ō83��k��~�Z.���>��a�"Wð�Ns�S��Nv��ۛ{i�#���ˉmt37�T^9�eUJ���?Z����W�J �^�6��!�M���Xy��`��������,�
x���*D��#��r}���=��Fhn��R��g:!��#B*X�c���y~��򊤂��^�F��::���J8��u'�I��x1�2V�bq�؎�t-�Q���v���[L����ڮ�9b�V(.(;��d�&���gϖE;8����������4�*�������`)�{$��w��㙐3�8�}�S��Y,?t;�����m�kvJ���1����N�m�\�ӛ�m�*�<K�\r�t9D��̊�w����:��z�c�X3�����=7�u��(�{�@&;u8����8`r�3-�G��x��֞/0�*�i5/�u��mv�a�ɗ�I�s�a�]�q�H�e	8��޴��s��E�����Z���L�ºAjf,<1̖chm?}��=��G�@�	���8Ve_��X4+M������7���4��1�Ґ}��GO��W���y��b��NE'MXh%�v�&΃�I����3Wv�T<e�z2�S���d���;_�k���߯�6�+�:���&�� Hbg�?i��!���;�$���
h!�4��Sc 䞵�4k��]��/r�
����*�J�8W7I�+Dn�Y��+��̬�y{p���Xp �X���r��5�*{�ˆuz%�~�cOd���!r�Jc� `�C���O����l��6Rn��>0��][�u��@(�Aׇ/Ϭa�a��k%�0V�p��$�>;y�N�s)�=��u�AҐD�C�;z�,G��F�ռ�`wʸ��1����cH�1t���c�������2.��=���8�]5<���ЭhM%���͏��[�sa�+%���ё�d�!�c�<�cјn��ݲ�C�e��:`Izs
����`�N�����Tb����ꑫ����Ŝ����ALb���ӌ�³����N�ᐕ�T8G4����drcBVC����[��\>�uO�vu	e���Y��X�>@hs_X��j��)����0-��:B�T抍=��W��9�b�A�!iM��r�SFzc�`4%k��ޗr�݇����{�Иv�DS3�wG�:��J��Z!�P�YE)Sw���mj%
	[M�@ �'����?�Cd��o[�P�#g�Q#�ڡ��=��ќ�8Ga疓�UQ���:*�H�5Ć�    (�z#�dr;�M�{�XJ]���E���؊�루��8|(�W��"�ŋ�dNyLQū��<���?!ɾ������,���i�6vĐ�%ߨ�ځ�,�v�ޜ�����$��h��[�*r-�j������8lw{�H_XYɔ��A�Pu�dtq%(+,��"�=_q�DI �ߩT"�5��\DF�����ã�W��l�KnDJ�'���l3��$+Aʬyz�n2��R��&�*F̶-6t˱�!��&}�NԿ�%�s�z��]0�������u5x9����.��]�T;��Do��RX��CD��)�R�v����{Ѩ`2�ø�X��S��� /I���|9�odOL�i⠁8�@���4�rjA{�������M�d���[6
�Ȣ�e��Sb����CcЭ���(u�
��)����YPߑO_>}��mS
��-��/N^`?�Foij9e�۞Є�VsY� @�����G0����fj���:�uJ���6��,#T��#�^�p�X�W<z��܂*6R,�	L����:}P�Ŗnnۮ���)5��k�QѱP��8�\��` _#w���H��(\B�T9&oy��|r����ʙ[��⤱��e��͙��A�>eʫ?֑<�yE �1Z����� � B���#x������EB5�Q�2R�˕	2�����y�������/^_���cY8��S�á���Z,<yV2�ft�����{Vj�>&ɖ!����o�\J�%й�+l��v�l��:"�v�2���a��:��ǩe�^]ƕ��;,R�䮬�WaG�V|͎����!�M�FXr�è����ΰ0��M@�X����:%!�Ҩۙ%���Ũ`�_�f���V}ҁ�Kw�>��2˻��Z�&�%KpQ�*a�������*,��%>O:|���q�&UL����֙��<8\o9�N_����[*�/W£����R@�R�y�ճt��)��o�\@��u�l$	�-	gՃ�5�k�>�r
�`r�IXP�<)�W�r�������E^�~z9Z��D��;8��uԥ!���KM�Q=+�&��1��o:B���P�BJ@��J,���RV0���]VQ���M_������An{�3��,���dE�3-��$>�T�����3K�6!��4��q��u�0�η>�	Oo��1[�T��  ;�1��"�$��2����_�1[BÚmR[T��8x�3����Ԥ"�j�����=F-|�=fG&�P%��/�v��tu���~ч���F���G��By,��3����u�˳���K����l�]IFe�
t������p�����c�y�����r�]l�R�(�~#e��U6�1XwyN��7�+�R��~eI�(˻��tx/����(Ǿ�茮h������r��|z�)���(�i���bY���!��sz9�~�������;�"w���Դ\Q`�,���짣`)�bI�'�8Q�]C���[��w�,y������E����b��(t��J�x�uj2�4�w<���|�Qe�=�A�C���+Vy�ҽ9$�f����J���e��>��w6�����u3��*�Q���|s�Z=��^��gO��=���5/��>����Wf���3��h��ۿ����|K{lnZk4�M���S�E��|�����Ǽ�'����({���*�����]m iu�sk!X��k���/~1�Ÿ������yJ�jJ��uP��u�N����v��=!-H
�8�~����(c,���N�!��Ӧ l�-��!`�h�V��
3�������n�aZ�R��*��I��(O��jQ���	�Od���]1�{��kŁ������C1e�A��,7nN�G�FT���E80s��>�v�y�gt���=�V��� ��j}þ���u�����5Ǒ;l��ú�s/Y��Y�YY�X�c��u�Jɧ�]���Ü�g�G��_tz�xPh�zs=����u��/6B����",gOSکb����K(+�>Z�1���CU����=Y'd�Y�V$�8ᴪ�����~�q���zSy�F�o g*d��k=o�>��i�8��\
�KYU
�Ū�g��mn �����6��ܵh.Όd)���RK2[Z���_��}S�Z+�Wg��k��B�/Gg�����z�����R��Sh�k��)�m`iS8�M���)9�������l���Զ욄�<��Q"���*R�eF�7��R�:���ܑ:o0.�ti�j2ۦb�� � ��kH�����=n�����Q[�j��jU|�I���.p�.�I��2��3�nZػ�������x�DGѡ� Pk������ <!!�.�=g^���{���y�&d���\U[َH	%qB8�`��`����{y����X������' {�t��5����t�2G T�1yPuF���m[��s�M2|.|����uԚ^��B�b����>��JAZɨ�ٲt
>V��5,W��N?�i�Al��=E3-�ge�]���q���9O�{v�îX���	0�S���^D}���ǞŮ`�,|m�
�l����c�)�^���o��ve7��wy��+��T5��"���ub��m��!u��$�,5R(�I@�{,ˮ�R;�n^����cP��e�Z��IaH�9D`Y-v�
����[�i�F[���>�8��a��c����yx���_o���a�Y���qr/���OTL(8y~���*�Ϯw�=��.����g� @���L#����,&s���N��V��H���&��Ç��*�i޻��G���n�7@��44X�M�����z+��
���w��I:���g�)<ivp�\����f���E���c����%�`�g��v������Pฏ�?�w�B�h���/J� ��ʚ�A��9Ӫ?4����w�<�XVj���LM�/�p�$_�Ȉ?X��3߱�n[Ls��Ρ�3�[YG3Iѓ����/����(�)̞͚����-���d� ;�F����[,��.,R��֥�zyub�U�؞�`^��ۇ?=�`��w�>�-Vu��oJ��sB~�p�3����Y�/L��4���0v"�ï5���f�J�����M��v/��/�>�[���,�OԆ�bVt�*x?����~��.�"�o�蠬�� F��&C-oc���<0�T�"*o�i3���ys�+�%�r���D�lb�+�	�gf�w�b�N��Y�hG���g��-T�Z� M?4`LA��*���
2��<@:�3�i�O��CT��L�b��*�~ؖA\G�z�?����m��z�ze���9�K�.���7�Ŝ�6�b;ٌ;n~z0���"�z�^�˻+�����#A�4k(��� �46��j]/��"b�#yjf�����>,B�r��<O/o�_�o���T�,^DANn��3-+�ph��xc����U�0�ɠ�&AS��đ$c��'����ӮM�+V�3�XK�9k7�)90�Z����-�¿����H�1�ej�|��L�	�;ϵ�����<�x�A�.�p��Og�	b8�LǴ~�ʲ�~�۞]6%_�P싕�ɶTD'{�u� ����|��"����8��h�:)U��K�S�CkמI�Z��li�G�hA���T����0�[*�}���\���j<�/�%��4��4�ơ}¦?<Q^y�!rL�����������4L�uc}�w"�|z�ǲ�:G,2�~��]*�mR��ɳ�J�Gk՞ݳъ烆*�E��:��v��pe�*z��޺��}Ī�u֛\�	���=�;���c�ȡ�2'u�X�6������D��ʹ�{v��ꔕ|�yh�{�	�Iu�;"-���Ma��� ��A"��!{�f��TlĿ��z9����qy�H;:(FW�:��=v�@m|6�d��%K��bJ��²m��5�LW���<�4�����������q�J^�ٖ��.F�œ9�s��Eߞ�{�v�'��|}�����\�� ��}Q?��    �_� [�">����b�u-3tW=%��\��b&�Ť����hXk�[/gj�e@��Um���y���w�8��
��6ةo�4�zC4��ּX}:}����$[8��jd����d�!�x_E3<�y=}r}��6$����D��9���p��@F9}�t�	 �I��3g�*�����S�&�wد��n��ٯ��d������bm
[��G`riĉz�����vӦ5%^��ʆ\N�`��F���=}��/�Ma�R�@7Rʽk� J������E���n�Q6�ޜe-���>��j%.-[G�tS�m�%��Q�	��D�r�����]T���|cK�/��Ԣp��	��7�om��z���qӍ�]�L����Dޯ��� �=�	��^��=�ߥ2CH�"�'J<�M��O�+WS�.}h�Ws�b��!�`!b[P��[���r!Ф�${�����?�|� ��z-�h�à])M+A�3�&�Tg� ��Ѽh�>F{�Pyڃ �J��	y�2�yI9�Ҁ��&��[ d1q�B��Sg�Y�{�4ص�F������ŗ�?l�%��l� ��JA1,�IR�����+���8��.u��g0c��pF�x�d�d�_~8��x���mӅ{ ���(�9F��)�e�L*)�~�7�fݳN���9}n͚O8VC��#;�(E��O�l*��F]T�0�[��� p������Y�Z.���#%��:3%Qd
M�e��v�M�s<�a����'�>����eYH4c��q�l� !���3̢x��Y2ԍ8��A���"p�=��9���Ϛ?�&8�-ǖ��V�ɚo�4��"�ڝ, ��%�D�`�&��"��<�m��=�P��+�e��L�G7	)�>ۉ�(��Z}E`��PŤ>`H���$��y;�=7\4v�`X|, č#�9�-�v(`О�M8@�ʢ�FO��/
Jh"aHDЬ��Իߔ�-�ZY�؀I�J�݀�!ѭ�G�Ϯp�M�Z��O|c�5�ъ��fM�Y������v��=����Iv�7vzpJO_��i�
��8YQ�c�md����8>��0P}_K�"�����g}V�u�|�!M�!Yk�tÆ�lv��m��pu$^9�o�"�0�$��jy��]�6�b�=���*��3�+����2��I����p�_���gGh%% Y���J@����<No�<��Qn~:��B�4�5Bc�f��|��R1�nOj͜0�)�`ԅ ����IwD;ܨ��%
�\�8V�C���+~�1�I��p���ɣv��A^�D&3�W"���
H˹3Y[s�r�v]E4s*�{��2�F��C��Q\?r)��r۳u�%W"8Eɢc-[�b���Qi���M�#��4"H�P>C�@�����9�J��_���dʽ�ݔ��:��2��FQ�lR�j�U�u�z�M@8��fp�|W��ZM��k���w���R��g�s8O���Z���.�֝��%zy�~�{�#�*���m�) �iM�lN�eh��q����t{ܳNt-��2@<b4�%�m�I����2�ZmV�_��ף)��W|���M� �#�R�?r<^aؤܺ�^��A��+���9�/�a4�����U�p����aX�X{�=��<c�s� �"�q,ݤ�Vnf�:$��S��_�ƦŊ3�Y�o&�1�^2ũ�p T���
/u������Ve�>�*�/�񠒬ڵV����`ͱ�d79�h���ͮ�Ǒ%:��)4�d!�jFіlC�Ԓ�w�Gma��Y��M��6z��E�<�ݵr�.wuqd�&�����+2#��D!��0Z�5Q"� J����_��A�lH�:r(�|$9���1�����S��M+vm*�"�=�l;~ۻ�����4`�qS#�X'�=ʺI*�Ne��Rv�7|�h�N?�&����j�d��!C��	\�C'�K���=��t�\'Vr|�Q��k%�g��������>&N���N~+�/H)'�P��w�,�v�R"H�v*K��w�K�/u���;x�m���S���5 m�
�-������]��)XI�x��;R,аjf��=EN��6=OԢ+N5��)"NB(�@t5��b+���,ϲˤ!I'����{�	K���B.�y|'uS�bm�H6����xG��q��i��sv�N֡Hv�X�n�*��:%�P��%ߍMWʍa��%�z��;�os��vX�g�5?��+k����O[����I�>4{�p��v�3K2��G)8�l#������Q��x�h�麫9A�m��^����,c��6�p6�6^�#:�od���yĄ�����ش��ކ�'���j�%d���/)<J�K��VN��m��<9m�S�7F��%*l�c��n�?�m]�:!�X����op�6���Fp�v٭L{v��X�����"~�) �|,�K��	���{�Fw�Y�IL���_�Q��H��65ڲ}M(����{MJLp�paD��<�vu�U�.3����"#�ꕩ���M�������l�����=�Wy��RR|^���\r���'�a{|GW4m�`�'ǅ��;8�DD�<�]����æ�����jgx	���;�@�OTd��Q_���<Z��ޚ��#�'46U�E�G���Ո�8���l)H�^HaDFaKp�ܓ�k)w�JU���9r��T�������Gi�]���\vMᤧ{�o毊��iǱ�p���V���]Q�O�ȱF�]�M��\
��6�E�y;]w5�I�Z�eRS�oI%�ӾZ�a����r���]>���(O
�T�y��o66S����@r$9�/Ƴ�-����ʸ" �c3Q�����֖nr�bQ�F�(����ȃ�ݰZ����Q�㷏��z=u�b����)geY���U�V+�s�w���\η�c�UQ�)�P�ش��G.�)��Ҵ�;ʨ�E%�<�;l�a��+_��S.ѵڱl����?l�)~���#����]���X���� �Hq�88R��*R˼J��JD$+S������C�����PO��<�)2ص́��9K��d��Q�����q>m�rx�$�(��)c'�M����KC|:S�X��e���s#��ϊ2����_�{?	iM�AZ�:��D�����_C�ߌ����Ŧ�Mw�p�(�IF�H�n�f{����*�|a���v�(���E���E8�zD8�y!)�����_�#.�结\����6JwMX7C3jv����i8�6ލ~9��(H��4�l�D��[g����_�jt��g���� bn�vV��t�z��Ov��b\"M�'3}���TV���J��f�af���e�qVU2�����	�9�n��Ť�j���T/w���Gֱ!Dh�(�&0i�E�@��$0�P�,���l
�])�e����
�^�Wl/�4k�,���G �����'����u�+�(���sK�qS���PN� �~H�;,��GY��̦�~�78HFM�:r�i�c�+2;����9�X9`��I����\��N`�A��?�ʬ�
�mP��Z,�.����7���ǅ��bU��NVw�@�F՜d�3��ˁ&5S m`'���T��gR��#Mݎ�\��[i�N��5���Ur�ekl���㷬���0�lY�Z֓�?�Y�RйL��R�=O��M�錼ɪ;j��N:sC�'cP����{u}3�9N��܋X@j���wZ�وՕs��t ��-��gy��t�IÙb��2^T��X ��ּ�cOmVj"ؓP�$�A6�H���d���dl�a��g�o,�� �0��&fԦ�����U��1��P=

tpʥvLg=�s�J�h��� 4z�di���9���=�<[{����'."(Zd�-��������-��W�2�i۩���b2�H��� Ê���{�������-G�щs-��=��aR�BI8�i�3�ws(���ۜ�V��d����L�X9��+�ߜލM�̘84Gڌ���"F$�FM�񝭘rF��ɧg�'�)>tG��E�Ja�    �7Ij��8Q��;S���ӒI��ݼ�����:v'�N��`e��?��w�}�F���q	��a<��B]OK�Q�=k�u�ֈ.��l(�Q����Z��ڕʊ[<�癭����� @�):��y|7��M!��멫Du\o
u�mSE��iF�"0�z{"d3���'��E(�.j2#E�Y������^u��_�7W�Q��l�J��x���N�)�e�?8W�����:S��)
6r�w��_�ߝƏ{lJ)�U^�� B���?��t�E�?�H��MY��ʹ,�P|�#S��$�:���w{xQ�~Z�LL
��ZYU���q�Z
V�����kH�X��V���������Ry�b��~"�'��Ʒ��5���
)���c�:�\i�A���3iE�`:�p�ϲ�L4��m`���UZ������>
պ�;}Q$'�f۪k|��r>=^��ԁ���[�DHBџ��*�捎��0��.�O@L[�8S��%v��#���,�2z�ڕt�F�?�:�����l�Jˢk�b���E潎`��z�wrW�8���,�=� ��M���s.��?�ue��)2��%*IٳVvF��=[����*�r�ȍ}���$�ܮcOlj��R9���-P"�l�״ŗ٪�K���5J�e�B�k��x����|r�j�IE��ǁ��'�R��S��]6A�S�`�ru2�8s��z����t�$O8 �x�� q��j]�
r}i���E�%Ġ����'Ȕ(�db����3=">��	��� �]Y�޶J��8mB�D��L W�k��%֪X�G����w��ǬC���G��0�A(g��~5o�b'K��L!���u7#�l1)�$5�����d���ԉ��t��i�E�8���(�A������	��I��+�?�qo1��a3E���i�#�11����e�.S����ǠX�
�ɧ�*�&5)f���j>h��Y!Ӵ7IT��d��=�x*�vj�[\���O{LBُ���g� �W�GV��J$��t�u���dt0	+ޖ����Ǭ=`��b�'���00t�/�慼	$v��� S�/}Ic�E��e*�"9T9��F֚Ux�d��N��"0&���	؅�#)wD��?�Ƀ��x�01�QU��N��>J^V-���Gw� �O^�����
��w𚭒�{If�K��t|=��7�[�-U*�Ux����:|m�L�>S��O?�ݑ���b�A10:|
;�Y�öIL�k�QU:l{w�Q~�bPi�Q5Q!���t��;z-�?o���!Zb$��)*3��9̸L�廠����㦼[ugP�7wm]���Y]�p8|3�W;,�Ռ��sKj�ތ���y@�g��Nʧ�0�8�tz3�D*�&p���*���U* �t=���Y�n�â�t7� X���!L/e���[s��|;�<=��$.�� �ޝ�����5��C�J��2�z��e���h��g�0��7щ&V�lԻ xڗ�W������5O5&۩�DXLT�i���$�X&}*�*ץ����qS�>:i]��TX��h���]�}���#�&�BF,�� �Ƃo��Ո%�Q���ߞ���֍�X��1�D,-�
���CL���d��{,ҥV㐓;��1����ԡ���;9�$o�'�s��*��T\pK�鰶�U�֔O+]���Ȧ�-є�"k�{�}��}�e�R��561��UT��Bn)��7�b�H�B)y�͑]c���ů����uh�pI�悖	�P���RS���p������`6�7� h��H��p�^"v��I�����Or��Y�ɲ�5U-���AUEvV!�ɮ��p�^3	r��Yo{�4#�ɞ4Vʍ`�l���������V���=�<S5Q���SA�U3�2BT�ڄ���}{�]Y�#S��`�<����Z�� J��2ᵜ����ǥB��R2*zJ���xa�Uʡg����ݨ�U{�*}���.���}�8��<Z�P6&.�~uYS2;L�-��g=9N5�<Mÿ��ғ�����y0H}�)"8��ުU�7$4Ş�lssy��P{ұ
�0��� ������Q[�����˖}�J
U�խ��R`O�5���-,Yir%�Җ8������"|�*}���@)l���4�Uc�E��8P��Y*���.l�C�ҳ;�?R�x0 �Ǒ�2�{(���
�d�V\�����??nZ��Rš"h�Mc��4��#մ#�=�O�y�"��CTR����� �%�7��و�a���e��\��������l5@凋�`��rz޵��W�yJ��1e��n�N6�:�Ů/�~�g#+�0�ժ-d6��� �I	B����f��_o��{��N�
�L���ҫ�j�ڠ*�`�7��)-&��J4�_iE�S�-7�,M��f<=_��=!�uX������|�	9�.��*�͑�d�H�_]Ia���i�j6���Suք*�s-r*�,�z�<q:�z�c�l)w���Zjm7�9�+���-�$���REy\I7����:Pw) ��2�t3�2�W@lo�M��(1QȊ� l۰ګ�=�����V�6ۦ���%��gw�[�+���iՒY���IO���o8{�ǯ��l��J�SK̜��j���
4�"��x��I<mɫF.��H���ڔ�$��|�ū�;��9���rOp�9��J1ڙ��Bٶ9+p^ex^�Q»)/.
� [�ǫ�v�i�=B�>I(E sVƔ)Jk�&��֖z9Sx�E��f��8�u�FvK�5+ck����a�I]7�)�V�X����L�ⵍ����O�y�qj�N3	5�-$�r�k�B�vg���8>��'���j�"b
����jLV{"��x��$��N[L�N�R�T=��s��Ʒ56n���?���������t�1NIK�N
ECB|�A�3
�z|bo��PU%�uV�S��ڡ�҇B�-�(�O0�Y���q���LN�CHx�'��z���o�-�"0��/u�Ŧ��;��� ���f�+!&����&Ooo}O���@m^�jJ��X�'+/X����l�Kl����4%'�Ԇb�F������9|�ŉ��hUo_�2���J�);ɩ����)L�s�(��\Z�u�ϔC�N� �u�J�˞���j�%3�@iQ|@�@%Y1n��?�^|�M#��1:5❐ �z�}j�|I��D���z��ͦR"�V�+�R�l(����mz�{VIj�M��K׫iR���&��tԖ����$�k*2)�#y�$�Cf���39ϰ.����)(�B�8@�8	h���@m�yK�
MbLb��'��P;%ts�"-�{�U�ҥ��.���<o��RpH��=��<��mC��R]����y�#��L?9�Q�/�RP}�`5���on�̱ g=�8y@��jB�aOCI���߾=ɮ���&��h��F�6�l�}��������=�c�:WG�4]�$���<k�7���|Yt�[vmR�n�hdEc�E��U7��I�ݸ^y�8ߟ�8v�T���̙���)QJ��B���l
Esh#u��MCA�m� ��Ǩ�)쑽�[p�o(��$6G�4I� NL���q����@H�s���l�r��A8��](p�/N�r�u�٭P�`"1yL��O�#ǘ�����W�}�I�K-�ϕ��~�J I�?��&ͧ�]e?E,<�G��x�P�Y���
c ɢ�R�$����9#�Ç��Lz$TF����G[�1�����7y��7�L"�_P�$�l�rM���G��-^�mך�p���cƌ_t �N�Ҏ���Ӻɾ�Mdj�$��1���ŴT�|�(�z{%�g]rIÔ�*0-��w:��u'�@��~z�t��AL�#4k��]�^W��n�d����=wS#��L�QR���RH�]z�mPD�������v�%��u�iGը)x��h"�F�&=_��DG[������#�[t+�rJ>��^ޝ:�6�K1	���ē�	ɵ�d��4�ۈ�|�ޕe��9�dU���    ,J4��L5���ٷ����\%��;Aj�HcdF�Dܽ��P4�KHo�$�5��^�I>���HV��nt����\��N�zu~�)�o���6y���
��@v}4^<��i���P]K�(�3�"|'����v�Sۢ}��U�zO���>���a�M�f����ď?��r�?o�M�o��d�����@���I
��F/���z�t)�Ǌ$� �E寋���������$8�ɹH�r<�&�q�1SS�5v3�e����z�54�/�0� ͒�A�<FA�jf�aP��Z�	��N���vc��2	x�6�Ft����e���5�3Oj���� �B�6�@�R����Ӧ�&\�hNk���%]�IŔ�4=�,��n�>�
�%v ����od�+^;x�ȹ#�N|�;�s����p:*���R�IS�&������a׳{�R�
��-�4��lU4��4����܈�����VE*&M�S����T������v�G��ǍH���my�uJ2�Ā3���8^�+�0N#��\!�w�:pf	zj���9x�1ų��p|�MPȥ�{i���c�����4���E�l5�N#g�(��V��ǧJJ��bRJ�(�j�&�们�ת��-~[�9>����'�p�Ɍ�D�\��n8m�<uqN[�y�~���I�wXS�"���ag�E�S*�V�H�P[Q;q�A"�"655���3p�AI��5�M\d�y�iV�NVE���ͪ������!��&���b�����vp�1FG�m�m��4g�c��;��|����>�·۔k~��0o6;l�e����k�M�f�)�4��vN��4��;�4{�p�����|��$�����7��~��q�8��%EC��_ݮ��u�A1�Y��p3��%# g��RBȭ܇[˖�6b� �h�mIm# �xA�l6��^��(����C(Fo�#�&x�d���eg	-����i�Rju$�m��GӒT:#�<��8���|y[L2����;�n0�z��m	 	��0�7��;�9�H�c��������j�Zq�"
(s�A��K[��ⲹM53�u;�x�R��\����Oo�ϛ����� � G�L��]�h��([,�޶b��os��Q�8t����ַ��<�M���)���4����R��$��Z���8Y�_���rW�ckPb���|����SS	48�t��%w�A���RQ>�Y�ۈ�?�3է�����ǗȵO�޶X4S������
��6�dbc����h��ښ�؂�l1�,r�F��hǹ7J%�����f9����g޷mA�6�'���nH���ץMm�ZG���6��2c�3Y�;�c�PX6j�]X?N��;��>�{8k��҅�$�����q@�1H?��7�ݲؒ�(K�=o��r��F������B����Y�82)yjl�U���T��m�ŗ����>�2�QR�eғx��QUR� z�����~�=VM|�"("���wX��F�s�9�5��|�mWK�m�BE��;��3�^��L[z(ܼk?=ʦp�l�Ţ�BM.s�B��S���"&ߞΛ�n�E�jj��,�,`;��9��5#�%��a�n��̻pe&9���R�c[?�;���dN
�w��s��`�J��q��R�<��������f�+�Ǿ��z-��n�}��%����7L�j���;��Bʹ�>ƋM$J�0;���T."�֜�jlY �K�}4Ĥɱ7�)i�{����$��:X�P��M����/H��AN�Ϡ�tEu|���!Ǘ�v�-����hΫ��d��lr�C����_]9�Ü*~�2����ĉ
]t��_?b�zz�ק=VE��K���y��u�a����� ��'6��C��ZnҪA�OǎL�G{��Ve�Hkr����[�Bդ9ҹ�q=�+*����#�J������_��=Kf�h�CWFr�+3���:db7kC�q�g��Ce��,�[� �5�9H圻�Jǎ�����1�<�������"1xe_"{%��I�TU��s���m9��
EUsz5�v>4�ղ�@��j�S�=��O[,
�/39d�bI�N�F��V���|+�k�6~޳}����{R��h�rLq6�H4+'�yQU�aU,�!2d�ۇL�h�TJ�8�.�y���<uL�S�f�Ke	��M�b�����>eɿ�|l+��(�~��5�Ēҏ$p�`S'�l�L�Pی�0 Ľ�_��G�ڔk{��-EǠ@���:�����XL�=�O�&O��-y�Pc�]HH�IF�	g��*{�~���3�[<)���q8��%��=�N.���Y��5r��
�ДH�6X�N��9��!���8>��=l1����Q5�YO����'i�����!~M|#p2n�aK�*�]�p_PK���DMO����y<�7��v�dM�9P�5��3��;����8�p�Q��#pӰD3��BE�gU$�j�F���vz�|Qٲ@}���,���[�h�+��Y2a�y,��!�YjP�r�8�K�"��h:�ON��[t�5:ʟ:�Adw�J.8�M���7"ޠ�K��-�9�A"�Ч?�s��� 1�H����VEx�����P��B(Z�����������Ќ쁟�o�
/{�h-��J�������q�*�?۲b�&�Xm����G�Q�s�$}X������a���|�R������	���:s�eMY��&'�!�8�Y� �������SP�Ӣ�O�7��MF�5�#�BK��L���ډ��j���i,���ɥKS��`�I�I�|A<�R���%�KR���X2aBFf�x�����qP�D*=]{w�j��B��[�����!�Dp%�Q-�N,��(,��L��(<Rw1�̋_��6��c�aW�l@ %,�����+�**���6���2��+����v7�0�YX3#�{H��)���|������۝�~Gn��k�)���kRG�ȴj�.��"E��a�0�:��.�2�^��=�FY������b�(��Oʺ։a�U�M̾�(/��G��$��&=W�/䙍D�w�Ws����ſ8�ky��{�aW�hW������9q�v���8����Ș1b,Q,)#���¡�� M�8P�&��c9�Z|��i'��r휂��h�+"��=�1���٣�d�]䝥�ӔQϕi)M�|i{�����ֹ�{�5G�L��X j�iqe��u�A����jt&�'҂2��
�.�N��0ɶY̜�d�/SD�)��̉u�|T����0~�dX�L�Y��)J�Q�6˦Y|�IP��Lx�7��po>���KYj�Y�� ��K�h��������Q6Xs,�x����1���Qr����Uxy��7{�if��ۦ�^S��q��.'�M���J]L[]3���lىlo.2���������y��
�8�vm�XCN��;��BT��+�����,��ܲN�|q/l������ʨz�|��i]���ac�b�QST�#�j`/?2��ޛ?^���uo�=���2��i��`ưTq* h-�VN��z �aP�A!��Z�$Ŷ�
������X_��ɝ!B	Q�{]�e�݊�D�A�@1,�hӖ�%x�Q-PdG%�(�	{��C������]�6���W����.�܊(�{��AZ�9o�yӆY�PEMD"�<�Z�Fu��������@�M��5	����7�kq�����tDJ�C���>޾L�X'�����L`���d�Ⱦz��Y5O����]Lu���qQy�J�o����eP.�x�#�j�uΑ���,���� m�Ș����p���^H�ߒ��G�"��s��R�u��F�~��MeIo�QC�S�z݉Un�) b���Ci;�A�RH�����Qs����5�kN����?��9�= ���p<�� *;j��Gi>��z�#���6ńmR�-��4����gh��v��H�>�A�L[�ʅ���1�d����F!�-���s��I"-��$*�,�v�3y��Ǟ�Z��?'��PXP��i���)�==���`Qj���Fө���    J�6>�^s�P��3K�=�2x�i�=�\(Æ�҇�<|���hr�2�����e]�r�U�I��4�س�����Y"b{�����BT�Oe ����ٟ���N�s�ǒ��DH~yW���ܛ��Z�z�o��\I������e���q���.oHϷ�cOUk�11#�q�dS�W�xڈE���&��lr�a��r���zz�@5�P��byA�C�n[�S߃Ss�v��/�$85���E���[Rg|wu��d����}�A;?CqR���TdϞf-|�.�֨���ϚL��s�n<�����v] ��R�ve��BFH�)��z�E;9~w��]�:�:��x
�R� ��x��9E>�:�gr�n��9;��!y�P}��c���U�5�������Y�h=�����zP~���RH�T�������-ّ�y>ҐT���� �O]t���e��b��iӵ)9R�W���4�N�9`Q!y�r8���˞R;��<�o�`ɋ?��?WA~��,޼g��2҅�PX�{r��c�UM����L<�|�gvto���@��)c�NG��gΜhŗ�|�X��;�Î]�:�F��7�Nާ�H����+rp ������2Q�� ���aQ_Wү�x������Fұ]a۶%�M��rIY�G'��i�$�y���V]Z��lGО]�bB�k��_��R��9��}#J�j�l�"��R���
.����';m�i�Zt�W+c�*fۜEЬ������iC,��ǁ�A� ���&5�Ilð���yZC/�^�����$�d\�b�B�2079m��_����f[n"s��S�@�� ��(�Sq���ؼ����Ӯ�HVmP����F��~���F%F=�.�"�,�jH�ə,���5�D�YV�6E;;��>�����QΛ�o�b"�F:s.��	;I�
o��˯����9�4D���4A%_!��T��ɦ��J�����~ؔ�R�UѤ��v�.��a��V��o�{k�b��� ���$��V������b�A�A�*��]��"����^}���}�h5Gu�\)B�5��Q�~��{��=FE�>O
N$9j��SU�A-E�_��w=y�n�z;�0���\NU �4$��T�0˦�O{bB&�Hp�+����6�~״��$}���E��FU�-��{l%U'�;�iM��F�_��/O��Bg��te��'�8��e��JX���H�8���pޒt4J&l�2��G�Hn��5@@ы,���)c�<V?��v�nz5����Q"Mrd/c]��E�#È�] ����c�O��V&
���䐃��C�~��~C�M�(�'�?��6�O�s�=��MǷ'��o�Y�;�70D&s	� �[�W�M���	������C��1�QO�V�fby�p�% �'��҇)A%;�=�ʞJ�ݲM}Ԋ���[�nz8`�W�A��QPG��ԍ�E�Q�0�*���Ѳ �iO�o�;�6MC�
V{���6�/�8���E���~�V�ބ���~�:��f�3���q�~����YZi������r{�|����ن����Q��6#���ߏg��+��2t��#A���	u�.%�;��m��u�Ჴ
�8�8W��l,�b������78�V�\���c�I""�
j��q����T�H��]1;U@af6Y��bH�l����r)R�4va<ꔂ�㵰U�Ǡ�����˳Ic_�DlL�fW�䲿w�0��~�C�`�T�8���|w�Pr/�#�|yڳ@�X&�j��o��Qn:)�"���r��,�-e�<=��Pl+-�����7���T�\�yl�H�삁+7�8xWY�-eɺ��k[�'���e�D�e6s�K4-���e��(��ڎ���bi�E@i6O^;t��8�����@�bv�lٵ����9K.����8k���0��p�g뚓8��H�|9��s�9�mG��_ʏ���Iʀ#k���r��'CPX�8C/}f�/	���R� �#�z0���L6Dcj2������q�a뮶:�U�ͺz�T�}�466S��)/>�ŠRZN18�$����8oQ��lX+�xx{��U[��E�2��敪�Y����
�WU����H�$񐩗$RUŢ��R�� 	�~�t�E��aRo@*>`�z�|���d�ȋ������6E����M�2؅�+�Ѫ��l,�Ȳ��˼�ɾ��Փ�א2ڇ�P`O�p�r�#�w��=�Ε%�⫔�"~#2�l`��x	pzl('wؓ��E$���,��̜�������3����Zq�Ɗ:R��B  �M��e�)�SLx�'ْ�L��/)�{���%���"]���!%���m1Ǒ�4l��NAy8� ���MWPBU�s{wڵafjcr��e�}T�$*�q�PPr.�����z3D9�˴l*��s�?��z����[���3C����ӿg�x��ݤ�S"�TX�bm
)������U��y�d̡a�;�\J�n��j,u쬶�j����T���(����C�K�m�(�b���b˧L:O�x9v�Q��ǫǟ/�<��N[l�6`�RDݖx��!p4��DzBlj�1�z��_Q��Dƕ�b��5M�NE��\*�����lp(����?w���M�x]��:����Ь���ר8ѼŤ4fa���]��j�覅��ʡo}1�z{jkpw�mah�9�,$]�T�oQ��>&*�Q�\OROke�M>%��xƺ�"�w�]�ͣ`�8-+o6�[L*u��Y�
Q\b�%��2�G����H ?��=^��c�A	�sK�t�����%J*��'9m
��R�Ԓ�BJ_STu�O�O�� s0����M�p�M��@'�%o�����uTt���/Kx�A5�,�*S�p��^�5��R*�������&��6".Z�+S����F�ꚢe�@L�g�[��TgBC5�4��ؑ�4g�4�ZO}|F��M;���lO��J���&G;�3Ա�������d� ?�AI�d��+���E^Q>lJ�pXO��RYl;rY ���V���G��͸��Bb��|Y�1+Ct�7~��Rt3ڛ�7^�n9ՎCCl�`ג���AR�\;~[����P����5_|Y2�m�⃐ܽ����x��S�x�%Ɗ�,|�ZҚ�i�$y�������pvO*z�8�҉l�IH�R8���T9�
��Zeӑ��k�'��H�/8mUsp83z��:�DO�yc����hZ�h��h��Q��* �F��8�/���\����S�
�qr�nm�+�Ԫ���<��]O��Y������-x��+�˘�eu=~/��f8���J�߉�y�A><M>�d��+s_]Q��'K�(��#3׈|f����}X?*F�/e�y�E�Э����=��*ś��g�jҿ�Y��T��5��	����(�@�7�v��������]p��8��{�����Q�O���i�����0k��@��W6J�W�t9����h&��|�*�Y��BJ?�{�X��a�[]��%������ޱej�;�� ��Ig!k�PR�Q(�B�Zے<�zw�t'I:,@H�ih}$M��W�[B��v�s_��[B����	m;a[�
�i���������x���w^ڦB���W�\`�bD2!,����6Hݖ)��$J!�����@`���K�o���=u-�Z��!�6�L�"h_���Fx���������=�-��
�&�4��\����͆2>�C}���t�&�Qa�I�O�,e���P���p|3�������	�ޕ��͍��z����6�?�������T�p���Z5P�c$���7f������1If2�z 8����4�J��h��%����;lBȌ@'��CRq�����Y��l��/S��&=��{2��xj�:H�f��q��v�c���"ž�F�b(�dT�Y�]�r���0���H���q�� v�f�#N-�w�ۏ�|i��7*��HR 0`�f/�?�����m�~UT#U稬�@K5YސF�M�~S����:{��@���x��T[tE����b�ͳߏ���m �  1)�!f+'7���F��&�h�������&s������ź:^�iq�eP+p�㏗�K���	�F0��I����5߲���(z[�?��s��u5[DS�@�/1" ��f�?ɕ]�[R��yT��l������Z�Lv
�'�!o��;bl�ׄ�p|�����k�֕��h:~ژTYc{;�:j �y��Ek��y|yz�dNR�Y,s��ꈇ�'Q9�q��Z(ʼ��b2<P��H]�ʅ�/a�9Ȗ�y{{����P�H�T��8�Bͣ�#rL��;����r�a�G=6��3"k�����Bs����3��Ga7����l1i�����X[8(�v-VG#jr᰸~}{��	ah��z�㒅�>�4��rw�4���i�v��@c�y� %
���b��6������� �9��J5iq��5���稉��''��ȡ�]M�z���=�� ."(u�WC[Ȑ��%�{KG���F{v0�lN��go�`g~5�L�&�9����Fn��{�ăl��Y�0�����qZ�����W�����ݕ���7���OWQ+pi�j[��3vO�N���U�R���d
p�F������+���)�G$��\E�.�j�  ��7V!Ta� w���;���]��=_�"��(��;1U�J��T�`@����9��b�/��m2H�mi��d�nVQ�Xřg�"I#H}y���O[왂C��޳�׶L9��B\֎��,�ӫ�x�k㪙�i���A��#�Zc�Î�v])��*o����|7Eҋ����s� XϏ����|��;�Z4eΕD�a$�Ւ� ���Ȍί��e�
�}\����kTr��/6�H��(!"���|F�}����s��mq��Ь����Η�H��o�ro��1�\lu�ǫ:~������QVG�f�B�F�ďB��?�=�C�7�1�L��?]���(r�cGB8����š7&�aa���N{,�T5yd{6qin[�eK�N4�ɛ��GxC������R�;��*<E5`(��bi��궘{�E�SY��T� T����>�2�<�l�h '���x�9w�6��Lѕ��j*�a�w	��}�p	�̙=�^�.��V̀9o����r>�1�8�����@� �2���1��_%A��.O�I[L7r�~�t~�8�����G�36q�����c�1��f����;�»I�RHm4des�O��=+Jt��P�Ф%Ì`SI���6:�)�Ɠ�a��Α�2��� n>B찯��ؿ� T�l����zQa����P5�vt������յ^��y��$�����H�U4bQ�O�s���,��-n-QrtS9�:���5��C'8>*y��<n2h6'yJR����ҝ����d�K�]�ߏG�����Bd<J[I�\�w�f�G������)?��E���(iNgvl��ɫK��×�����U�Ul�%�M"��X
9'Ú�����#:��ly@P����%�?�o

 �6]�����|k����*0SoI$'BH!�oJ��\�6cF���K���o�ݞ�
���Le�$�Mk��s�9����дe�8��8�ĺ��u�X�Ü.s��]uu��[n���T��|5�5m�)�--OR������vXe&��� b$���:�ѱeZ;k�`�l�&K�G@���/��K���d8�˚��!���b���)�K�����ރG ���iH��F�<n�m�H
q�zb��n��=�*aY괛�Iz,�dX�!N���:��s1�M[z[� (���z����_��@�"�%�M�ơ��8�ah<�4X��p��Iʊ�G�����8��i��C과��[�Q�G��d\`�0�p2	���n&;�=~E��=SǽT���˰rƞc}��:r����ɫ7�Ӧ^�Z��Vf�MkU���<. (d�oKz�H��P����k�l����]���uY��+�%��)@p�@hH�B��b��Q W���W�w�=���v�@��X�j�qIt*��1���-qɵ�)E^o�jɚ��CZ ����G��]5�'��ڳLm���c'���� 	E�9��w�p{������ꢆ	#E�=���S��#����'��C���o$ND�d9��(T�V�d������Sm�Ci�5*�t(�+�
�e�>�����;Z']-�9>3�?���%a�B�s�PD�㫊����4�c��u5�'��7S���Ruw°M��&JRM�kp/쿍c��('.��H��d������/�����xA      (   ;  x��W;�[G�ߞ�ha>=?e�5`� [� Nzzz,\��.�o�ЁCG��\<��IHཇ�BMWu�`��{�R}$����(���̐C/c���OGyڸ�6�;�q|��$qYG���-���;r~�k�^��*{�b$������]O�sm�\����D��JZSs��o������e/K i i�|�AK�Z�Y��ŖC+�m�g��<%rC9&�6���T�L
]FZ�f�����4�i	&o�(�<��0�6͑ݨ�E�s��t�~}��D6j�S�;G,RQ�z��5zNu �g��5���t�pah�	�[$�6Nqsq{��X�4�&>�LV|�9��:(Zk1��,�|���*�Rp#7G�q[쌩h�G�\�	=�QζѰX�D��fRSG5��QK1�ܢ�8Z�|C��F\Y?�Z�W
%H<�n��Hbe�?�;d@�1�L-F_�)g�}}<��ۚ�a�9����p��j8шu�Y�Q����8�56-��J!g�
��{tt��q�&h�r��<�yQ����@`gL��n��6[c�l��"����D!�*'
�j��E)��%M�����~��݄�:h@��$jB�bsb�l?^��5%��
ͤ78�Fr1PN�ZoM�u�Iv����y���̽;sh`���`D#W�4���1�`�E4������x =JN��+V��������4\����\��S�mI�)������פ4��Uu�G���i2$���$7�d��=��m������Y�����=(��G0@0j3V��u:�\c��]�/��y[�w�n$��i�"��5�4�fJMB�~����u��l�c�������v��8�g��/{��[�\CR��V"ΐ�k�.Q�F9]h�iC'���|��i�������v�E���ܲ�#�7�JXi�k�0\���foݳ
*��g��K�Qb����d{�EÎ͏6VȢ�FS��':]���% �m����576�
����tS�mU�!�G�ZW���7�:���5��U2%ГҠ.�i��sbk v������� 3?���F*0Q<w%L$��ۇ�~�E~������� �DF�      )      x��}�r\I������} �Q�8�=�cs*��N �Mj��-�P�Xk����x�5�Ǟ��{��P�����pjU{U�K��IK��u�uD��G�zw���j�(��VR�=c���5�_�V!Y�������=Đ4IR���6�L=�b�=9����b<�j������T�)�L�i��I��̮�&��)e���7q���罓%�&��;j�6j��7��y%kqY���E�_��e�*i��AùLEZ#�V'sVv2>7JPN�;���4��V���Jڐ�׍,��\eX���������l&�s.i�ې�d��M����!��i�� s���dk�4�JXb���%9�e��������3��],��KMy]��)�3]*CRn^�I������{��ˢM��}���.���9���R�$[5v��HM쟰����>�Цl�&[������ И ��SUR���JQ�_�/9O�����'�jʔ^����J
�I�^�Z�X���bCeA{��m��O�hH	!b
` \i�u�Э�>��c_N���6�r���$K
FF�ZEݔؿٙ���;R����eK�cS��4��b��XR�n��%>�`��^�*Eﰾ�,�T����V���m�l�����������: ���]K��.������eC3��6�6���Jy��w��T�+R��+]��ݛ���R����A�X� �H�H�N)�"|�G�Z|�!g
�#"C�2��V�d��� n�}���!�#��L��l(�$�᧣D3j��zqp��6��-&//��C�hHI��@�>kYSi�6c�5����T�2�b�%i�$|jdB��8+�3H[p�a�@0|S[O�Q��S6*�
�(g)0�<�#i3�Y|��D��>�হ"��= ��k�#��X%����o��E��ȉT��`+�E�删�*�V����8 `�>ٚ�-c`m�L@cAt��F��r�am5�?[�ʘQd`�`p�2HV=�餔�V\���	�~z������RJفL�lo�-Vg���_�s�|�����m���*���Z�
�����q�^.�͐�|1��Cڒ���G(6#s�u8�tr��}�{F��:��q�m�������@�leTE��b)V�iq��_��4ݞ&5����2+�ϩ$������X��NA������T�ŇR�Ukb������b��&��q����r2;̱�*m�ZfD�&����
ֶ+����v�R�z�>Au�}Y�����̙�Dl��4C���{� ���ƙ	�&ӎ���L�:`yǰ���wL��ɚt�n�%&�\���@(&k�U�HQ���mnWm��
F�s������Ƈ �����!dq� �����M�n�
�=d7�@�z8NE(���Z��YV8�����<���0�y�A��U�V.k�X�SY�.�U%C5^(0�&�H^dR�V^���y����y�(R��TY3W$���� �q�{+j��l.:�h��h��7���U� �7|���X�����(H��w�Y��������N:7lhr`�r��m��@$�q��~�_?��>��osN��b�l�,������8��XN��M֖��2�B�F�B���]齊�+66}G�9D$�`;j
��d	�'T�p��x���}�L^��)(]�bR r�e1��2B�:�y'�J�{���}[��ETb�i@�|+��فv(�6=j�׌��a� �k0��{���ɰN=�uQWN]@�\�L=�C9���?Po]gPI�P�8��� 	�[
jM��+q�A���2=[��i�_XPJ�:,']`�2p�[?�73T�l�8'Gά8����&u*�-��8|���?����o/o�,�ϫ��G��\����˼�\p��N�v͸^�BO�,�:Aw�;�G ���M	K'�!��6����h��dFi�V-��o�,Q���(\�E�������]�Zo^&CDkI�K%N���zV��u�!��8��'����d\*Vy��+�
�B�2 �p�]�kT���3}~��%m�4��ك�'��E�9
k�44��8��i�f�^:��E�B���h�C& #$4"�r�����th�_�rmJ��������.��RD�܋�
�H-�E�ف�@�I��_����i�xw.�!k>�f�^��}lmH��
r(�θ���>@z��R�[?-V3����=�*#22W�uU���4����~���J)C�?EƟ�q�:ڧ�qȾ�|��CqT��֓2���@�;t�s��9;��D�5�2�8:G���/3��k)7�l�_ ��FiS�������8�����:jb�7:_	���w:%�t�1�����8zZl�e����*�y�~���2�����|#i@�,dY	� �L�a4(��q�Y� g'�g����+6���ii]Ӡ�4t��\=/������x���y�נ���Q
Q���^��۳7�s\��J-� ޜ.�̂����&��8������_�w�� �	.P��$��?�PIG|Y�_���˗������	�h&g�Y��4�J\�Ǫ�3���E�ڔ��=/}N��"�p�dg��U�5��q@⠣GGlu=����u�9W[��58��	��c`�N�,�__�Ϊ+d� "��R�0×eP�z�6���?��o��+4�!���k�8B��
�m��,�O��b��ʮ4�q:�-��5p�3`O��s�H-N||�+�מ��	��M�b�4���U,�;~��'Wغ�Qy�~b��ä8����h>q|#�7���j�H���K#1E����s�/�K'����ߧ����D-G����
�!�V ޞ��%�͡0��+ N;�)��ߐ\vҶ*��'G⤯7��́����:���]�
&�󨻆�Z�8�������Zd�Hª�eQ��%O4ߘ�0(�� �<�^��7���ɩ8�2��z�J��;_^pP�J�B^ϗ�V��3q�(Z����١j'���=���2[hUT�v�'�bNO�)�@xj�9��=����$Nn`���уDER��}4����>eM]��",/`m�g92�r�SaT�
��k����
��8�'`��~��7�p�!��x�a�=S:7jw��{6�4�7�Pr�*e�U�	�:�dAxm�����z�O4�������eGn����R9hMC�[������wA��y���9h�E|�A�I
�௱Z,��>N�`w��N�kF;��qmw}2�q�U�>F��䗟��X彬7�\刖/d].8On1c���d��I{�ǟ��������! ��5���2��Մ4��9�<����O0�}@946��D�s��=�ZX�ЪV|���N���ez]�Q��Ε�j����-pw�w���?��i�MCƺ�m����J{�%Sb�.���a�d��k7#-N���zն3�}O&sCf�;� ��@��1��zԒ�8=g{�{��09;A>xi�df`]�Ȏ�(�R1T��8ݮ73� W�iD�*ˀ�_e�!z԰�4�����J�͑9v��ԑ����Zk��;@��nj�c��wll��3t+uc|(�~s0�M%�ȳJ�$�n��f��`PE����3���j��;%�p���3�~�1��d[>�<��'�6��wѮ�ͤBgG��9:c�FOUܿ���
�V�o���������\L�����Q��_@�f��-���6�'����R����n/���T��$�����}���z|
J�]���!C�Je�H��,�_���D3Tuc��jP����q�u�2*nR�Ds�0�u���+�J����.]�����
$�x�A�_o�����"���b"@E����}�IԡQ��gqN?��g�^�E���R�ȶ)c�	�ր�##���9�~n@�7 I�,̠�F�e�Y;:����'�|�y��3�i�ᙝ{��\$E���Ԋ��glrQ�er�8]��뚅��G�J�.��T��Gq�����R�N"Tb�� �K �  A���k���.��M/ ���h�˘+�CӈAc������P���V\���˗ɗ����{����^I��ȁ�!�S����f�W*�z�M�
������qi;y .^/3�9���&@�]�?Wֺ��;b$W��7�bQ�z��$�R�8p����%�f�F�q�����0'��������8�a��%hut�+?��3���K_=��������5��՛�b�ײv���
4����lgAj0���*
D���&�Y]Y ����b���T���-��4ok���۪8E��Zpq�J_~��1�_�5ŵ�E�/�=¡�0���3�$.������6GF���b��87z�b N���1:蒸<�
=�s�^K+��n��\`L���&ś�P�;�/?�"��Nckk*�4��z/亂IP����3�����sI�(��6�y��)�Rs&R9����ߦ��½(�'P]Hin� l#��M�zy��f���uo��]o��2����ԓm�7%.�����>�`5y2�D������!�:PO��8���&��q����8�k�(�l���R*ud8���XE�X�����Z�(����.�`���cF��P���c�7�m�������a��p �� ��w�@V�N���r�\'+! ������"%�����2KcJ��:�7ǝ����ͲY���cc׽���fQ��܃�P���	%8��i�3�A��>��͛��9�c�J"���@�
�%����������eGՎ
�Q��ǧ$�k5p Ͽ�����������vY���%b���;ͩԕ8�������+R�"	��l�����T�4�d��;q�^6�a��jU���̽�
 ���-$̢}���п�h��V
��y��{^"��J&c�P1�WXO������i0�ݯ�)� �!�H8? �-�{y�M�i
|Q�Dq�Ba[� J�x8=4�m���?�����1�H7(> Wzqz��$�L��u��N��VOӉT&瑇�\Kw�&s���D&� "�j_\���`�VZ̓���V��R��!?�	`�W70��L����!�Ҕ�y����q<�EU~C\]���u��HF�t.�<*�@EY��)��L\!m�q;C�i����x�8��JW:Xj�w-������}�� ��ָ���I8�+�C�je�c�N���N���9to�)(�������y��8(_�������g������-��iIZ4��`��$����۰�X/'7�CL�\�br�X/��(4��?���A�ܶ?N�j:��e��H���牑�]����P\m�7�;��<���h4%[����B�t\E^����|�i�s�� �r���y���nX�
:+�}u�å�0��]t@-U��o��ƞV��(0�sG�W�^��{�����v����@8J �Ay`A���A\�����bsN�hl	��T�]���@,b����G\N��6]�R�'p���O�@L J(�3������9^+�Y���O���"����v�J\�������f�S}Hk2,w��`i�4_����>����� ��bc��U���X(���ij�v�2y���'��e����l��K?ET��(i������!��Yk����@s#��N���;h!a ��~����K��f��	C!������N	�;��Z�N���cq����5�p�A��gZ�C0�#�eC��T~��ly,�.�}����^L�47�f��t0ws����t>b��TH�Mc@o�`���:e�p�7�z�7/k���+�h�C�ؙ�q/���fhۢN9�˾��f����X�eB<�è�v�*���|'�/V�V����c3���qm��G�u�u*~_���v������&1��[�]�5~�"�;HR����(n�s�}*��.�v�и�x���#���}��Y޺S���s����NOܖ?����0*vhqss3�2�h(|%ix��@rSE�
�C�v��z��T��@�އZ��^�G��ORҍo�xڃ_*�v�b�QM�t�?A����ǀ�F~��wD�+  ���WC|��r��3�
ƞ
�\��l��7�P�AZ��4������-�H<0��
<U�������.����̮�7���^h��i�[L�'C���7��@����2P�	_%�s��Y���Ӗ�4l�G��r�R�0x����p�|�x��f��z\PY��P%[��xF2�qgBǛ�*w���a����w��s�
��C�?K�KI-!�C�	!u�{�A�r#p�N�����A����;���&��VXj�@A\��y��3t�d��
�w�{��4!ۊ�v*Tq{���޻`����޼�����Mڶ{P�^+q�PH��*�n�&� �����3Дڇ�
P�,7�7�#@��Ȳ���!Уo��'�M����Wi���#�#�=k�������f�8���~�K���5$ ϣhy�Λ�;)��P-�FS�o/�킋�{}=ØF4�J���T��O�I��$���	�<���#}�>�� ���@m��Z䞮J�W=F&#n?��e��P��WC��=a4 p��l�|�L� n�Os��Y�>��/��vO�
O��6BPJ���Ź��, ~�_gX�����W��ɮ����x8g2)V+n?��-�X�Ӳ�ѠT
t
�1Xmp~#ɞ]�&s3q��a���m�\�d�~t�8����<J��A�RT�q������8
J�o�4H��_����-�� �
x=��9�z��R9�;��9�KH�[�:r�^"im?f ���R�]e���F� Ω�ϩ�����#6�g�|�*��g�WF��2��Q��-�����-������ާWԼ--���H���g���B���SqG3��K��y�%46h�G{k���&�>����Q��`������f�>�Y���L���3̭~̡�R)�T��h����TV�%o��jr��{{�3E���w5�|D�.҆��GN��\g�rႇ��{�,/�z����F�����^����� y�o�&�����
�>(?�S���=��|��?�Q��Nz�*�Z���n�+Hc�:��w�n���}�,f���9���Qd�V*>᫅>m#Fqw"��3�QTz���w/2+�d��qa=�����a��>CA<hmbr���w���`"r��wY˓ywp��j�MQ(����̺F���O����ѻ��%8ѝ��e Żu��$�0-w#��!v.C.VY+��#����Jܽ�c�L>ª�s�{ٹ�z�\ҋ��ܼ�v������}��gh���T/B���(ܥ���*�Ș�U�]
���H����g�-@�[�,\��,0�E�C�Y#,o�蟷3�@d�w��%E�� �#*$<�c�,Yq� {H��c�*�JO��9�~ko7��yp�4q�/��f�&�k��?���v�uB�*�u��D�?�Qٴ�)eĂF�;/FT/��8h�E}�I�o�s���A��.17yk��R�h|�7V(�����G�3�RjYA�Y�+ә�Lu�I�(U�[��{�@�-�LG�u6����� b��R�E�:�Ñx�P���Ӈ��#۴���`�M;>T��׳W�a�_�`�
� [Z�:�.w@�9�:��x8��n���?�����9�]��6�#yК��+�_@��hm҃�����#��{�%�>�S�?#(��F~��I�K�L�c8����GZ.���ۗ�%^�o@�j��C����%V������ӑ�ԟ�+
ߔ6%&	��w�]�P�+%�A�3��{�iQ�ӧ��B�M������J�dMPi����ϗ��,����$���u'Ђ츪ic ���?�ϋ�BezG����?��O�	�z     