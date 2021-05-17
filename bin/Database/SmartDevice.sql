--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: SmartDevice; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SmartDevice" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';


ALTER DATABASE "SmartDevice" OWNER TO postgres;

\connect "SmartDevice"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: User; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."User" (
    id integer NOT NULL,
    name character varying(40) NOT NULL,
    lastname character varying(40) NOT NULL
);


ALTER TABLE public."User" OWNER TO postgres;

--
-- Name: UserAccount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."UserAccount" (
    id integer NOT NULL,
    "userId" integer NOT NULL,
    password integer
);


ALTER TABLE public."UserAccount" OWNER TO postgres;

--
-- Name: UserAcc; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."UserAcc" AS
 SELECT "User".name,
    "User".lastname,
    "UserAccount".password
   FROM (public."UserAccount"
     JOIN public."User" ON (("UserAccount"."userId" = "User".id)));


ALTER TABLE public."UserAcc" OWNER TO postgres;

--
-- Name: UserAccount_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."UserAccount_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."UserAccount_id_seq" OWNER TO postgres;

--
-- Name: UserAccount_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."UserAccount_id_seq" OWNED BY public."UserAccount".id;


--
-- Name: User_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."User_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."User_id_seq" OWNER TO postgres;

--
-- Name: User_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."User_id_seq" OWNED BY public."User".id;


--
-- Name: User id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."User" ALTER COLUMN id SET DEFAULT nextval('public."User_id_seq"'::regclass);


--
-- Name: UserAccount id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount" ALTER COLUMN id SET DEFAULT nextval('public."UserAccount_id_seq"'::regclass);


--
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."User" (id, name, lastname) VALUES
	(2, 'Elif', 'Çınar'),
	(3, 'Mehmet', 'Yılmaz'),
	(1, 'Ömer', 'Demir');


--
-- Data for Name: UserAccount; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."UserAccount" (id, "userId", password) VALUES
	(1, 1, 200),
	(3, 3, 407),
	(2, 2, 116);


--
-- Name: UserAccount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."UserAccount_id_seq"', 3, true);


--
-- Name: User_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."User_id_seq"', 3, true);


--
-- Name: UserAccount UserAccount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount"
    ADD CONSTRAINT "UserAccount_pkey" PRIMARY KEY (id);


--
-- Name: User User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."User"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (id);


--
-- Name: UserAccount lnk_User_UserAccount; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount"
    ADD CONSTRAINT "lnk_User_UserAccount" FOREIGN KEY ("userId") REFERENCES public."User"(id) MATCH FULL;


--
-- PostgreSQL database dump complete
--

