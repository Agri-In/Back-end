--
-- PostgreSQL database dump
--

-- Dumped from database version 14.12 (Ubuntu 14.12-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.12 (Ubuntu 14.12-0ubuntu0.22.04.1)

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
-- Name: dosage_unit; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.dosage_unit AS ENUM (
    'CC_HL',
    'G_HL',
    'G_HA',
    'KG_HA',
    'L_HA'
);


ALTER TYPE public.dosage_unit OWNER TO postgres;

--
-- Name: drug_character; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.drug_character AS ENUM (
    'ALLOWED',
    'RESTRICTED',
    'PROHIBITED'
);


ALTER TYPE public.drug_character OWNER TO postgres;

--
-- Name: drug_type; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.drug_type AS ENUM (
    'PESTICIDE',
    'FERTILIZER',
    'SEED',
    'OTHER'
);


ALTER TYPE public.drug_type OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: _corporation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._corporation (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    building integer,
    city character varying(255),
    district character varying(255),
    postal_code integer,
    region character varying(255),
    street character varying(255),
    email character varying(80),
    foundation_date character varying(30),
    legal_name character varying(30) NOT NULL,
    phone_number character varying(255),
    size character varying(255),
    storage_id uuid,
    CONSTRAINT _corporation_size_check CHECK (((size)::text = ANY ((ARRAY['SMALL'::character varying, 'MEDIUM'::character varying, 'LARGE'::character varying, 'VERY_LARGE'::character varying])::text[])))
);


ALTER TABLE public._corporation OWNER TO postgres;

--
-- Name: _user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._user (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    account_non_locked boolean NOT NULL,
    building integer,
    city character varying(255),
    district character varying(255),
    postal_code integer,
    region character varying(255),
    street character varying(255),
    birth_date date,
    email character varying(80),
    enabled boolean NOT NULL,
    failed_login_attempts integer DEFAULT 0,
    firstname character varying(30) NOT NULL,
    gender character varying(255),
    identity_document_number character varying(255),
    identity_document_type character varying(255),
    lastname character varying(30),
    login_disabled boolean DEFAULT false,
    nationality character varying(255),
    password character varying(255),
    phone_number character varying(255),
    status character varying(255),
    storage_id uuid,
    CONSTRAINT _user_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[]))),
    CONSTRAINT _user_identity_document_type_check CHECK (((identity_document_type)::text = ANY ((ARRAY['CIN'::character varying, 'PASSPORT'::character varying, 'RESIDENCE_PERMIT'::character varying])::text[]))),
    CONSTRAINT _user_status_check CHECK (((status)::text = ANY ((ARRAY['ONLINE'::character varying, 'OFFLINE'::character varying])::text[])))
);


ALTER TABLE public._user OWNER TO postgres;

--
-- Name: account_manager; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_manager (
    user_id uuid NOT NULL,
    managed_company_corporation_id uuid,
    quality_manager_user_id uuid
);


ALTER TABLE public.account_manager OWNER TO postgres;

--
-- Name: active_matter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.active_matter (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    active_matter_name character varying(255)
);


ALTER TABLE public.active_matter OWNER TO postgres;

--
-- Name: audit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.audit (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    date timestamp(6) without time zone,
    status text DEFAULT 'PENDING'::text,
    audit_type_id uuid,
    storage_id uuid,
    CONSTRAINT audit_status_check CHECK ((status = ANY (ARRAY['COMPLIED'::text, 'NON_COMPLIED'::text, 'PENDING'::text])))
);


ALTER TABLE public.audit OWNER TO postgres;

--
-- Name: audit_checklist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.audit_checklist (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    checklist_name character varying(255),
    audit_type_id uuid,
    storage_id uuid
);


ALTER TABLE public.audit_checklist OWNER TO postgres;

--
-- Name: audit_firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.audit_firm (
    audit_id uuid NOT NULL,
    firm_id uuid NOT NULL
);


ALTER TABLE public.audit_firm OWNER TO postgres;

--
-- Name: audit_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.audit_type (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    audit_type_description character varying(255),
    audit_type_name character varying(255) NOT NULL,
    audit_checklist_id uuid
);


ALTER TABLE public.audit_type OWNER TO postgres;

--
-- Name: auditing_firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auditing_firm (
    corporation_id uuid NOT NULL
);


ALTER TABLE public.auditing_firm OWNER TO postgres;

--
-- Name: consultancy_firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultancy_firm (
    corporation_id uuid NOT NULL
);


ALTER TABLE public.consultancy_firm OWNER TO postgres;

--
-- Name: culture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.culture (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    culture_description character varying(255),
    culture_name character varying(255),
    variety_id uuid
);


ALTER TABLE public.culture OWNER TO postgres;

--
-- Name: drug_active_matter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.drug_active_matter (
    drug_id uuid NOT NULL,
    active_matter_id uuid NOT NULL
);


ALTER TABLE public.drug_active_matter OWNER TO postgres;

--
-- Name: drugs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.drugs (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    commercial_name character varying(255) NOT NULL,
    days_after_residue integer,
    drug_description character varying(255),
    drug_dosage double precision,
    dosage_unit character varying(255),
    drug_character character varying(255),
    drug_type character varying(255),
    max_application integer,
    CONSTRAINT drugs_dosage_unit_check CHECK (((dosage_unit)::text = ANY ((ARRAY['CC_HL'::character varying, 'G_HL'::character varying, 'G_HA'::character varying, 'KG_HA'::character varying, 'L_HA'::character varying])::text[]))),
    CONSTRAINT drugs_drug_character_check CHECK (((drug_character)::text = ANY ((ARRAY['ALLOWED'::character varying, 'RESTRICTED'::character varying, 'PROHIBITED'::character varying])::text[]))),
    CONSTRAINT drugs_drug_type_check CHECK (((drug_type)::text = ANY ((ARRAY['PESTICIDE'::character varying, 'FERTILIZER'::character varying, 'SEED'::character varying, 'OTHER'::character varying])::text[])))
);


ALTER TABLE public.drugs OWNER TO postgres;

--
-- Name: enemy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enemy (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    enemy_name character varying(255),
    drug_id uuid
);


ALTER TABLE public.enemy OWNER TO postgres;

--
-- Name: event_publication; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_publication (
    id uuid NOT NULL,
    completion_date timestamp(6) with time zone,
    event_type character varying(255),
    listener_id character varying(255),
    publication_date timestamp(6) with time zone,
    serialized_event character varying(255)
);


ALTER TABLE public.event_publication OWNER TO postgres;

--
-- Name: external_auditor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.external_auditor (
    user_id uuid NOT NULL,
    audit_firm_id uuid
);


ALTER TABLE public.external_auditor OWNER TO postgres;

--
-- Name: external_consultant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.external_consultant (
    user_id uuid NOT NULL,
    consultancy_firm_corporation_id uuid
);


ALTER TABLE public.external_consultant OWNER TO postgres;

--
-- Name: file_owner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.file_owner (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint
);


ALTER TABLE public.file_owner OWNER TO postgres;

--
-- Name: files; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.files (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    name text NOT NULL,
    type text NOT NULL,
    url text NOT NULL,
    file_owner_id uuid
);


ALTER TABLE public.files OWNER TO postgres;

--
-- Name: firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.firm (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    building integer,
    city character varying(255),
    district character varying(255),
    postal_code integer,
    region character varying(255),
    street character varying(255),
    firm_name character varying(255) NOT NULL,
    firm_surface_hectare double precision,
    storage_id uuid
);


ALTER TABLE public.firm OWNER TO postgres;

--
-- Name: firm_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.firm_analysis (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    analysis_date date,
    analysis_description character varying(255),
    analysis_name character varying(255) NOT NULL,
    firm_id uuid,
    storage_id uuid
);


ALTER TABLE public.firm_analysis OWNER TO postgres;

--
-- Name: firm_assignment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.firm_assignment (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    in_duty boolean DEFAULT true,
    firm_id uuid,
    firm_responsible_id uuid
);


ALTER TABLE public.firm_assignment OWNER TO postgres;

--
-- Name: firm_responsible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.firm_responsible (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    firstname character varying(30) NOT NULL,
    gender character varying(255),
    lastname character varying(30),
    nationality character varying(255),
    phone_number character varying(255),
    managed_company_corporation_id uuid,
    CONSTRAINT firm_responsible_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);


ALTER TABLE public.firm_responsible OWNER TO postgres;

--
-- Name: group_request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.group_request (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    status character varying(255),
    group_id uuid,
    user_id uuid,
    CONSTRAINT group_request_status_check CHECK (((status)::text = ANY ((ARRAY['PENDING'::character varying, 'APPROVED'::character varying, 'REJECTED'::character varying])::text[])))
);


ALTER TABLE public.group_request OWNER TO postgres;

--
-- Name: image_storage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_storage (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    corporation_id uuid,
    user_id uuid
);


ALTER TABLE public.image_storage OWNER TO postgres;

--
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.images (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    name text NOT NULL,
    type text NOT NULL,
    url text NOT NULL,
    storage_id uuid
);


ALTER TABLE public.images OWNER TO postgres;

--
-- Name: lmr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lmr (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    region smallint,
    "lmr_name_mg/kg" character varying(255),
    drug_id uuid,
    CONSTRAINT lmr_region_check CHECK (((region >= 0) AND (region <= 11)))
);


ALTER TABLE public.lmr OWNER TO postgres;

--
-- Name: managed_company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.managed_company (
    corporation_id uuid NOT NULL
);


ALTER TABLE public.managed_company OWNER TO postgres;

--
-- Name: managed_company_audit_firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.managed_company_audit_firm (
    managed_company_id uuid NOT NULL,
    audit_firm_id uuid NOT NULL
);


ALTER TABLE public.managed_company_audit_firm OWNER TO postgres;

--
-- Name: managed_company_consultancy_firm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.managed_company_consultancy_firm (
    managed_company_id uuid NOT NULL,
    consultancy_firm_id uuid NOT NULL
);


ALTER TABLE public.managed_company_consultancy_firm OWNER TO postgres;

--
-- Name: operator; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operator (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    full_name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.operator OWNER TO postgres;

--
-- Name: parcel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parcel (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    parcel_name character varying(255),
    parcel_surface_hectare double precision,
    culture_id uuid,
    firm_id uuid,
    storage_id uuid
);


ALTER TABLE public.parcel OWNER TO postgres;

--
-- Name: principle_groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.principle_groups (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    code character varying(255) NOT NULL,
    group_name character varying(255)
);


ALTER TABLE public.principle_groups OWNER TO postgres;

--
-- Name: quality_manager; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quality_manager (
    user_id uuid NOT NULL,
    managed_company_corporation_id uuid
);


ALTER TABLE public.quality_manager OWNER TO postgres;

--
-- Name: supervisory_board_member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supervisory_board_member (
    user_id uuid NOT NULL,
    managed_company_corporation_id uuid
);


ALTER TABLE public.supervisory_board_member OWNER TO postgres;

--
-- Name: token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.token (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(1000),
    token_type character varying(255),
    user_id uuid,
    CONSTRAINT token_token_type_check CHECK (((token_type)::text = 'BEARER'::text))
);


ALTER TABLE public.token OWNER TO postgres;

--
-- Name: treatments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.treatments (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    application_date date,
    application_end_time time(6) without time zone,
    application_start_time time(6) without time zone,
    drug_application_stage character varying(255),
    materials text,
    observation text,
    treatment_type character varying(255),
    drug_id uuid,
    operator_id uuid,
    concentration_unit character varying(255),
    total_quantity double precision,
    CONSTRAINT treatments_concentration_unit_check CHECK (((concentration_unit)::text = ANY ((ARRAY['CC'::character varying, 'G_HL'::character varying])::text[]))),
    CONSTRAINT treatments_drug_application_stage_check CHECK (((drug_application_stage)::text = ANY ((ARRAY['PREVENTION'::character varying, 'FIRST_OUTBREAKS_APPEARANCE'::character varying, 'FIRST_OUTBREAKS_APPEARANCE_AND_PREVENTION'::character varying, 'FIRST_OUTBREAKS_APPEARANCE_AND_TREATMENT'::character varying])::text[]))),
    CONSTRAINT treatments_treatment_type_check CHECK (((treatment_type)::text = ANY ((ARRAY['AERIAL_PARTS'::character varying, 'FOLIAR'::character varying])::text[])))
);


ALTER TABLE public.treatments OWNER TO postgres;

--
-- Name: treatments_parcels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.treatments_parcels (
    treatment_id uuid NOT NULL,
    parcels_id uuid NOT NULL
);


ALTER TABLE public.treatments_parcels OWNER TO postgres;

--
-- Name: user_groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_groups (
    user_id uuid NOT NULL,
    group_id uuid NOT NULL
);


ALTER TABLE public.user_groups OWNER TO postgres;

--
-- Name: variety; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variety (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone,
    version bigint,
    variety_description character varying(255),
    variety_name character varying(255),
    culture_id uuid
);


ALTER TABLE public.variety OWNER TO postgres;

--
-- Data for Name: _corporation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public._corporation (id, created_at, updated_at, version, building, city, district, postal_code, region, street, email, foundation_date, legal_name, phone_number, size, storage_id) FROM stdin;
\.


--
-- Data for Name: _user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public._user (id, created_at, updated_at, version, account_non_locked, building, city, district, postal_code, region, street, birth_date, email, enabled, failed_login_attempts, firstname, gender, identity_document_number, identity_document_type, lastname, login_disabled, nationality, password, phone_number, status, storage_id) FROM stdin;
262a0adb-11f2-4949-8b9c-51607e217d2b	2024-04-03 21:07:12.879978	2024-04-03 21:07:12.880008	0	t	\N	\N	\N	\N	\N	\N	\N	soumaya@gmail.com	t	0	Soumaya	\N	\N	\N	NOUHI	f	\N	$2a$10$ueCTR9NEhctZl.6EZ7vngeT0XrTHPvmiXttDNRsIBdWoys4NacjSK	\N	ONLINE	\N
c6f71871-32d1-4b48-96ac-0c36b6050617	2024-04-04 10:03:57.946995	2024-04-04 10:03:57.947012	0	t	\N	\N	\N	\N	\N	\N	\N	sidati@gmail.com	t	0	Sidati	\N	\N	\N	NOUHI	f	\N	$2a$10$qf.w1OSmKqkdz5juvMeLYO2nic59RsydR2ZnRBWbSHkUv/YkUqPua	\N	ONLINE	\N
46c07d67-6152-415c-ba51-a9fef6641a36	2024-04-04 21:45:52.172828	2024-04-04 21:45:52.172976	0	t	\N	\N	\N	\N	\N	\N	\N	taha@gmail.com	t	0	Taha	\N	\N	\N	lasfar	f	\N	$2a$10$0EyrgkTGB/IVOeW2e0V2keaiGs/BIAc.Mazpq2tkxgi6gYBbL0WE.	\N	ONLINE	\N
\.


--
-- Data for Name: account_manager; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_manager (user_id, managed_company_corporation_id, quality_manager_user_id) FROM stdin;
\.


--
-- Data for Name: active_matter; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.active_matter (id, created_at, updated_at, version, active_matter_name) FROM stdin;
e469a299-5602-448b-ab8f-1205cfeb8f8e	2024-04-03 21:00:58.574142	2024-04-03 21:00:58.574254	0	MDH-28
\.


--
-- Data for Name: audit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.audit (id, created_at, updated_at, version, date, status, audit_type_id, storage_id) FROM stdin;
\.


--
-- Data for Name: audit_checklist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.audit_checklist (id, created_at, updated_at, version, checklist_name, audit_type_id, storage_id) FROM stdin;
\.


--
-- Data for Name: audit_firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.audit_firm (audit_id, firm_id) FROM stdin;
\.


--
-- Data for Name: audit_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.audit_type (id, created_at, updated_at, version, audit_type_description, audit_type_name, audit_checklist_id) FROM stdin;
\.


--
-- Data for Name: auditing_firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auditing_firm (corporation_id) FROM stdin;
\.


--
-- Data for Name: consultancy_firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consultancy_firm (corporation_id) FROM stdin;
\.


--
-- Data for Name: culture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.culture (id, created_at, updated_at, version, culture_description, culture_name, variety_id) FROM stdin;
\.


--
-- Data for Name: drug_active_matter; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.drug_active_matter (drug_id, active_matter_id) FROM stdin;
666312a3-fc94-4d83-9976-c55c92247626	e469a299-5602-448b-ab8f-1205cfeb8f8e
\.


--
-- Data for Name: drugs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.drugs (id, created_at, updated_at, version, commercial_name, days_after_residue, drug_description, drug_dosage, dosage_unit, drug_character, drug_type, max_application) FROM stdin;
666312a3-fc94-4d83-9976-c55c92247626	2024-04-03 21:02:37.091772	2024-04-03 21:02:37.091805	0	ANANNA	0	This is a test drug	70	G_HA	ALLOWED	PESTICIDE	12
\.


--
-- Data for Name: enemy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.enemy (id, created_at, updated_at, version, enemy_name, drug_id) FROM stdin;
e045f074-87ce-4c5e-b294-b38262abb215	2024-04-03 21:26:57.526651	2024-04-03 21:26:57.526719	0	DOUDA	\N
\.


--
-- Data for Name: event_publication; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event_publication (id, completion_date, event_type, listener_id, publication_date, serialized_event) FROM stdin;
\.


--
-- Data for Name: external_auditor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.external_auditor (user_id, audit_firm_id) FROM stdin;
\.


--
-- Data for Name: external_consultant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.external_consultant (user_id, consultancy_firm_corporation_id) FROM stdin;
\.


--
-- Data for Name: file_owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.file_owner (id, created_at, updated_at, version) FROM stdin;
\.


--
-- Data for Name: files; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.files (id, created_at, updated_at, version, name, type, url, file_owner_id) FROM stdin;
\.


--
-- Data for Name: firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.firm (id, created_at, updated_at, version, building, city, district, postal_code, region, street, firm_name, firm_surface_hectare, storage_id) FROM stdin;
77219ce6-4963-4730-82d4-e6f0ce48d03e	2024-04-03 21:01:08.802055	2024-04-03 21:01:08.802098	0	533	BIOGRA	IDAOU TANAN	\N	SOUSS MASSA	fjigjfg	FRM-3	10	\N
6fefd876-5025-493f-adcb-17ea8bbd2a71	2024-04-03 21:01:13.689319	2024-04-03 21:01:13.689346	0	533	BIOGRA	IDAOU TANAN	\N	SOUSS MASSA	fjigjfg	FRM-2	10	\N
68702f86-5992-487e-8102-01dfbbe9ed65	2024-04-03 21:01:18.985791	2024-04-03 21:01:18.985814	0	533	BIOGRA	IDAOU TANAN	\N	SOUSS MASSA	fjigjfg	FRM-1	10	\N
\.


--
-- Data for Name: firm_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.firm_analysis (id, created_at, updated_at, version, analysis_date, analysis_description, analysis_name, firm_id, storage_id) FROM stdin;
\.


--
-- Data for Name: firm_assignment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.firm_assignment (id, created_at, updated_at, version, in_duty, firm_id, firm_responsible_id) FROM stdin;
\.


--
-- Data for Name: firm_responsible; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.firm_responsible (id, created_at, updated_at, version, firstname, gender, lastname, nationality, phone_number, managed_company_corporation_id) FROM stdin;
\.


--
-- Data for Name: group_request; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.group_request (id, created_at, updated_at, version, status, group_id, user_id) FROM stdin;
cec006ac-6c50-423c-bf57-7e7dbe1bb708	2024-04-04 23:40:22.942921	2024-04-04 23:40:22.942997	0	PENDING	9534a325-c568-48c1-b39e-964d4d73eecf	262a0adb-11f2-4949-8b9c-51607e217d2b
\.


--
-- Data for Name: image_storage; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image_storage (id, created_at, updated_at, version, corporation_id, user_id) FROM stdin;
\.


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.images (id, created_at, updated_at, version, name, type, url, storage_id) FROM stdin;
\.


--
-- Data for Name: lmr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lmr (id, created_at, updated_at, version, region, "lmr_name_mg/kg", drug_id) FROM stdin;
45f11d08-9e1b-43e4-89cf-71a35b08b2a6	2024-04-03 21:03:34.187913	2024-04-03 21:03:34.187945	0	7	0.80	666312a3-fc94-4d83-9976-c55c92247626
66db25f4-4df7-455f-b919-ee7fe82f9d56	2024-04-03 21:03:44.695521	2024-04-03 21:03:44.695569	0	0	0.80	666312a3-fc94-4d83-9976-c55c92247626
\.


--
-- Data for Name: managed_company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.managed_company (corporation_id) FROM stdin;
\.


--
-- Data for Name: managed_company_audit_firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.managed_company_audit_firm (managed_company_id, audit_firm_id) FROM stdin;
\.


--
-- Data for Name: managed_company_consultancy_firm; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.managed_company_consultancy_firm (managed_company_id, consultancy_firm_id) FROM stdin;
\.


--
-- Data for Name: operator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.operator (id, created_at, updated_at, version, full_name, phone) FROM stdin;
dd89dc65-e96a-4a47-90e0-699b7aa529f0	2024-04-03 21:27:10.717465	2024-04-03 21:27:10.717498	0	\N	0654857612
b451c146-41e7-420c-851b-db74de46ca8c	2024-04-03 21:29:54.572334	2024-04-03 21:29:54.572448	0	Anas lamghar	0654857612
\.


--
-- Data for Name: parcel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parcel (id, created_at, updated_at, version, parcel_name, parcel_surface_hectare, culture_id, firm_id, storage_id) FROM stdin;
248d8f43-8f58-406d-b668-278ec1d27ece	2024-04-03 21:04:16.240534	2024-04-03 21:04:16.240598	0	B1	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
46581f7d-3d88-44cf-93a3-d752d239064b	2024-04-03 21:04:21.408402	2024-04-03 21:04:21.408461	0	B2	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
d49d028d-e0e5-48e4-bc46-e89d49c14ddd	2024-04-03 21:04:25.367843	2024-04-03 21:04:25.367865	0	B3	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
99fd496b-6f1c-4d46-a8a1-ed5ab1727fcb	2024-04-03 21:04:28.915948	2024-04-03 21:04:28.916059	0	B4	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
8580b596-32af-4bbf-a860-d30a8c4e2b8d	2024-04-03 21:04:37.701054	2024-04-03 21:04:37.701092	0	A1	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
aba76e73-343f-47c0-a14f-1a5e59fefecb	2024-04-03 21:04:41.679344	2024-04-03 21:04:41.67936	0	A2	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
f0a45458-cfcc-44a3-bdc8-31d6ac797ede	2024-04-04 20:16:56.272654	2024-04-04 20:16:56.272785	0	A3	1	\N	6fefd876-5025-493f-adcb-17ea8bbd2a71	\N
\.


--
-- Data for Name: principle_groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.principle_groups (id, created_at, updated_at, version, code, group_name) FROM stdin;
ed64856c-a0bf-43a8-ae77-c0b47e31a3d2	2024-04-03 21:06:38	\N	\N	QM	QUALITY_MANAGER
9534a325-c568-48c1-b39e-964d4d73eecf	2024-04-03 21:06:40	\N	\N	AM	ACCOUNT_MANAGER
6efafdf8-9e86-47c2-9463-c7332fb37eb0	2024-04-03 21:06:42	\N	\N	ADM	ADMIN
a79b9365-0857-424d-8933-04b2b3945f0c	2024-04-03 21:06:43	\N	\N	DU	DEFAULT_USER
\.


--
-- Data for Name: quality_manager; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quality_manager (user_id, managed_company_corporation_id) FROM stdin;
\.


--
-- Data for Name: supervisory_board_member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supervisory_board_member (user_id, managed_company_corporation_id) FROM stdin;
\.


--
-- Data for Name: token; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.token (id, created_at, updated_at, version, expired, revoked, token, token_type, user_id) FROM stdin;
d5dc5247-0600-4262-bf27-fc9f778deff6	2024-04-05 00:48:19.672609	2024-04-05 00:49:17.581134	1	t	t	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaWRhdGlAZ21haWwuY29tIiwiaWF0IjoxNzEyMjc4MDk5LCJleHAiOjE3MTIzNjQ0OTksInJvbGVzIjpbIkFETUlOIl19.8rvXjs8tdD9VrHQLima_USisxpw47RmWjVTfymyT8Es	BEARER	c6f71871-32d1-4b48-96ac-0c36b6050617
e07bac80-4ccc-4112-a362-9b77317c4bec	2024-04-05 00:49:17.568094	2024-04-05 13:29:31.447121	1	t	t	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaWRhdGlAZ21haWwuY29tIiwiaWF0IjoxNzEyMjc4MTU3LCJleHAiOjE3MTIzNjQ1NTcsInJvbGVzIjpbIkFETUlOIl19.rfpRFoP3OJsYm1lNX9ltxKhO8-4J57gyb5MwoNqu_hk	BEARER	c6f71871-32d1-4b48-96ac-0c36b6050617
77451c9d-4984-445b-ab2d-c9da085f6aa4	2024-04-05 14:19:44.224744	2024-04-05 14:19:44.22528	0	f	f	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaWRhdGlAZ21haWwuY29tIiwiaWF0IjoxNzEyMzI2NzgzLCJleHAiOjE3MTI0MTMxODMsInJvbGVzIjpbIkFETUlOIl19.RUF7hFD_A9xZcJAnsmZGs3-RB4dz7pWp0H-O5_tHwpU	BEARER	c6f71871-32d1-4b48-96ac-0c36b6050617
38d2d084-013b-47b1-a53a-791ea4c62606	2024-04-05 13:29:31.383387	2024-04-05 14:19:44.247222	1	t	t	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaWRhdGlAZ21haWwuY29tIiwiaWF0IjoxNzEyMzIzNzcwLCJleHAiOjE3MTI0MTAxNzAsInJvbGVzIjpbIkFETUlOIl19.6PKfq5d758w6XM0Z8iDv5znGm2sllLiA61xPEkAYKf8	BEARER	c6f71871-32d1-4b48-96ac-0c36b6050617
94722dad-95e6-4c26-9a40-c33af762a180	2024-05-11 18:18:10.117238	2024-05-11 18:18:10.117305	0	f	f	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb3VtYXlhQGdtYWlsLmNvbSIsImlhdCI6MTcxNTQ0Nzg5MCwiZXhwIjoxNzE1NTM0MjkwLCJyb2xlcyI6WyJERUZBVUxUX1VTRVIiXX0.eQiZfegQzIFkrAlx1AIEeiAsEn86HV4kfUq98dFegIE	BEARER	262a0adb-11f2-4949-8b9c-51607e217d2b
92b1a86c-a525-476d-aea6-2b38d9997831	2024-04-04 23:28:41.400678	2024-05-11 18:18:10.135302	1	t	t	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb3VtYXlhQGdtYWlsLmNvbSIsImlhdCI6MTcxMjI3MzMyMSwiZXhwIjoxNzEyMzU5NzIxLCJyb2xlcyI6WyJERUZBVUxUX1VTRVIiXX0.ZfspIC0W-kbBNFR60lsCOjf8FuUsmRGikDqCk6h6qo4	BEARER	262a0adb-11f2-4949-8b9c-51607e217d2b
\.


--
-- Data for Name: treatments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.treatments (id, created_at, updated_at, version, application_date, application_end_time, application_start_time, drug_application_stage, materials, observation, treatment_type, drug_id, operator_id, concentration_unit, total_quantity) FROM stdin;
dc83f122-7712-405c-8e0d-a54d1a76294e	2024-04-04 00:26:23.15749	2024-04-04 00:26:23.157577	0	2024-03-04	12:30:00	10:10:00	FIRST_OUTBREAKS_APPEARANCE	Mihfada dyal dhar	This treatment was done successfully	AERIAL_PARTS	666312a3-fc94-4d83-9976-c55c92247626	b451c146-41e7-420c-851b-db74de46ca8c	G_HL	12
\.


--
-- Data for Name: treatments_parcels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.treatments_parcels (treatment_id, parcels_id) FROM stdin;
dc83f122-7712-405c-8e0d-a54d1a76294e	248d8f43-8f58-406d-b668-278ec1d27ece
\.


--
-- Data for Name: user_groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_groups (user_id, group_id) FROM stdin;
262a0adb-11f2-4949-8b9c-51607e217d2b	a79b9365-0857-424d-8933-04b2b3945f0c
c6f71871-32d1-4b48-96ac-0c36b6050617	6efafdf8-9e86-47c2-9463-c7332fb37eb0
46c07d67-6152-415c-ba51-a9fef6641a36	a79b9365-0857-424d-8933-04b2b3945f0c
\.


--
-- Data for Name: variety; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variety (id, created_at, updated_at, version, variety_description, variety_name, culture_id) FROM stdin;
\.


--
-- Name: _corporation _corporation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._corporation
    ADD CONSTRAINT _corporation_pkey PRIMARY KEY (id);


--
-- Name: _user _user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT _user_pkey PRIMARY KEY (id);


--
-- Name: account_manager account_manager_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_manager
    ADD CONSTRAINT account_manager_pkey PRIMARY KEY (user_id);


--
-- Name: active_matter active_matter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.active_matter
    ADD CONSTRAINT active_matter_pkey PRIMARY KEY (id);


--
-- Name: audit_checklist audit_checklist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_checklist
    ADD CONSTRAINT audit_checklist_pkey PRIMARY KEY (id);


--
-- Name: audit audit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit
    ADD CONSTRAINT audit_pkey PRIMARY KEY (id);


--
-- Name: audit_type audit_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_type
    ADD CONSTRAINT audit_type_pkey PRIMARY KEY (id);


--
-- Name: auditing_firm auditing_firm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auditing_firm
    ADD CONSTRAINT auditing_firm_pkey PRIMARY KEY (corporation_id);


--
-- Name: consultancy_firm consultancy_firm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultancy_firm
    ADD CONSTRAINT consultancy_firm_pkey PRIMARY KEY (corporation_id);


--
-- Name: culture culture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture
    ADD CONSTRAINT culture_pkey PRIMARY KEY (id);


--
-- Name: drug_active_matter drug_active_matter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drug_active_matter
    ADD CONSTRAINT drug_active_matter_pkey PRIMARY KEY (drug_id, active_matter_id);


--
-- Name: drugs drugs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drugs
    ADD CONSTRAINT drugs_pkey PRIMARY KEY (id);


--
-- Name: enemy enemy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enemy
    ADD CONSTRAINT enemy_pkey PRIMARY KEY (id);


--
-- Name: event_publication event_publication_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_publication
    ADD CONSTRAINT event_publication_pkey PRIMARY KEY (id);


--
-- Name: external_auditor external_auditor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_auditor
    ADD CONSTRAINT external_auditor_pkey PRIMARY KEY (user_id);


--
-- Name: external_consultant external_consultant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_consultant
    ADD CONSTRAINT external_consultant_pkey PRIMARY KEY (user_id);


--
-- Name: file_owner file_owner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.file_owner
    ADD CONSTRAINT file_owner_pkey PRIMARY KEY (id);


--
-- Name: files files_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT files_pkey PRIMARY KEY (id);


--
-- Name: firm_analysis firm_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_analysis
    ADD CONSTRAINT firm_analysis_pkey PRIMARY KEY (id);


--
-- Name: firm_assignment firm_assignment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_assignment
    ADD CONSTRAINT firm_assignment_pkey PRIMARY KEY (id);


--
-- Name: firm firm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm
    ADD CONSTRAINT firm_pkey PRIMARY KEY (id);


--
-- Name: firm_responsible firm_responsible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_responsible
    ADD CONSTRAINT firm_responsible_pkey PRIMARY KEY (id);


--
-- Name: group_request group_request_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_request
    ADD CONSTRAINT group_request_pkey PRIMARY KEY (id);


--
-- Name: image_storage image_storage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_storage
    ADD CONSTRAINT image_storage_pkey PRIMARY KEY (id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (id);


--
-- Name: lmr lmr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lmr
    ADD CONSTRAINT lmr_pkey PRIMARY KEY (id);


--
-- Name: managed_company_audit_firm managed_company_audit_firm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_audit_firm
    ADD CONSTRAINT managed_company_audit_firm_pkey PRIMARY KEY (managed_company_id, audit_firm_id);


--
-- Name: managed_company_consultancy_firm managed_company_consultancy_firm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_consultancy_firm
    ADD CONSTRAINT managed_company_consultancy_firm_pkey PRIMARY KEY (managed_company_id, consultancy_firm_id);


--
-- Name: managed_company managed_company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company
    ADD CONSTRAINT managed_company_pkey PRIMARY KEY (corporation_id);


--
-- Name: operator operator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operator
    ADD CONSTRAINT operator_pkey PRIMARY KEY (id);


--
-- Name: parcel parcel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT parcel_pkey PRIMARY KEY (id);


--
-- Name: principle_groups principle_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.principle_groups
    ADD CONSTRAINT principle_groups_pkey PRIMARY KEY (id);


--
-- Name: quality_manager quality_manager_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_manager
    ADD CONSTRAINT quality_manager_pkey PRIMARY KEY (user_id);


--
-- Name: supervisory_board_member supervisory_board_member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervisory_board_member
    ADD CONSTRAINT supervisory_board_member_pkey PRIMARY KEY (user_id);


--
-- Name: token token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);


--
-- Name: treatments_parcels treatments_parcels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments_parcels
    ADD CONSTRAINT treatments_parcels_pkey PRIMARY KEY (treatment_id, parcels_id);


--
-- Name: treatments treatments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments
    ADD CONSTRAINT treatments_pkey PRIMARY KEY (id);


--
-- Name: audit_type uk_2xw4g7pykmhfi40ww4repw4gh; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_type
    ADD CONSTRAINT uk_2xw4g7pykmhfi40ww4repw4gh UNIQUE (audit_type_name);


--
-- Name: parcel uk_5vkw3p2hrjxr5r2de2cjo1cnv; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT uk_5vkw3p2hrjxr5r2de2cjo1cnv UNIQUE (storage_id);


--
-- Name: audit_type uk_603wa6fb3xm918dm3kn3unc42; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_type
    ADD CONSTRAINT uk_603wa6fb3xm918dm3kn3unc42 UNIQUE (audit_checklist_id);


--
-- Name: audit uk_7asbdk3g9epmvtm7y89iwfwpd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit
    ADD CONSTRAINT uk_7asbdk3g9epmvtm7y89iwfwpd UNIQUE (storage_id);


--
-- Name: culture uk_8i1d1gja6qlcjmr8rh1kmg2om; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture
    ADD CONSTRAINT uk_8i1d1gja6qlcjmr8rh1kmg2om UNIQUE (variety_id);


--
-- Name: principle_groups uk_9rf7t2q5qxdfc1djetiyhg9m1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.principle_groups
    ADD CONSTRAINT uk_9rf7t2q5qxdfc1djetiyhg9m1 UNIQUE (code);


--
-- Name: _user uk_buoitwamy4goeykc8n0r8b5jd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT uk_buoitwamy4goeykc8n0r8b5jd UNIQUE (phone_number);


--
-- Name: firm uk_dk5s46u15eo9pqxuw0452v74l; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm
    ADD CONSTRAINT uk_dk5s46u15eo9pqxuw0452v74l UNIQUE (storage_id);


--
-- Name: audit_checklist uk_dokj3m4fbakkdhhkimgn3i7lx; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_checklist
    ADD CONSTRAINT uk_dokj3m4fbakkdhhkimgn3i7lx UNIQUE (audit_type_id);


--
-- Name: _corporation uk_fkjqb561x4e43t01fq6h1hem0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._corporation
    ADD CONSTRAINT uk_fkjqb561x4e43t01fq6h1hem0 UNIQUE (storage_id);


--
-- Name: image_storage uk_ftnapjlfggu359oy50ytd1dbj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_storage
    ADD CONSTRAINT uk_ftnapjlfggu359oy50ytd1dbj UNIQUE (corporation_id);


--
-- Name: _user uk_g9xumalujsfyrgka7ybe9yuny; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT uk_g9xumalujsfyrgka7ybe9yuny UNIQUE (storage_id);


--
-- Name: _corporation uk_jhwk648aparxtdko2crfb9leu; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._corporation
    ADD CONSTRAINT uk_jhwk648aparxtdko2crfb9leu UNIQUE (email);


--
-- Name: _corporation uk_jqp1vmv8xr8mlkb0msgo7wqss; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._corporation
    ADD CONSTRAINT uk_jqp1vmv8xr8mlkb0msgo7wqss UNIQUE (phone_number);


--
-- Name: _user uk_k11y3pdtsrjgy8w9b6q4bjwrx; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT uk_k11y3pdtsrjgy8w9b6q4bjwrx UNIQUE (email);


--
-- Name: treatments_parcels uk_m141jj6vt0gowne2tltuu0ke3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments_parcels
    ADD CONSTRAINT uk_m141jj6vt0gowne2tltuu0ke3 UNIQUE (parcels_id);


--
-- Name: firm_analysis uk_nbwq614vgigdkk8cgcaj08vdf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_analysis
    ADD CONSTRAINT uk_nbwq614vgigdkk8cgcaj08vdf UNIQUE (storage_id);


--
-- Name: drugs uk_o3h9f2fia8lbq2tog0mu4wnd3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drugs
    ADD CONSTRAINT uk_o3h9f2fia8lbq2tog0mu4wnd3 UNIQUE (commercial_name);


--
-- Name: token uk_pddrhgwxnms2aceeku9s2ewy5; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);


--
-- Name: audit_checklist uk_qgh50p7s8gk8n6vcm9pief4sw; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_checklist
    ADD CONSTRAINT uk_qgh50p7s8gk8n6vcm9pief4sw UNIQUE (storage_id);


--
-- Name: image_storage uk_ql8dlxwnlvommdhvadrfpjpxw; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_storage
    ADD CONSTRAINT uk_ql8dlxwnlvommdhvadrfpjpxw UNIQUE (user_id);


--
-- Name: firm uk_sm67gwdjoddga2woyh8hsdfuh; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm
    ADD CONSTRAINT uk_sm67gwdjoddga2woyh8hsdfuh UNIQUE (firm_name);


--
-- Name: firm_responsible uk_xu4vyanfsjbhic97oseilo27; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_responsible
    ADD CONSTRAINT uk_xu4vyanfsjbhic97oseilo27 UNIQUE (phone_number);


--
-- Name: user_groups user_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_groups
    ADD CONSTRAINT user_groups_pkey PRIMARY KEY (user_id, group_id);


--
-- Name: variety variety_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variety
    ADD CONSTRAINT variety_pkey PRIMARY KEY (id);


--
-- Name: firm_responsible fk1ehgyek7fmxt95ubkydofxta7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_responsible
    ADD CONSTRAINT fk1ehgyek7fmxt95ubkydofxta7 FOREIGN KEY (managed_company_corporation_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: variety fk1lqls2uf2vyaprktl25qyvnmo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variety
    ADD CONSTRAINT fk1lqls2uf2vyaprktl25qyvnmo FOREIGN KEY (culture_id) REFERENCES public.culture(id);


--
-- Name: auditing_firm fk3mm1vgr1gcihwwb0moe76627u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auditing_firm
    ADD CONSTRAINT fk3mm1vgr1gcihwwb0moe76627u FOREIGN KEY (corporation_id) REFERENCES public._corporation(id);


--
-- Name: account_manager fk3qm988g1b37412ynuwrhikkad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_manager
    ADD CONSTRAINT fk3qm988g1b37412ynuwrhikkad FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: audit fk45pa7rxx7kk8slb124wdglml6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit
    ADD CONSTRAINT fk45pa7rxx7kk8slb124wdglml6 FOREIGN KEY (audit_type_id) REFERENCES public.audit_type(id);


--
-- Name: treatments fk4slp7awp3xguig80a512nyp73; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments
    ADD CONSTRAINT fk4slp7awp3xguig80a512nyp73 FOREIGN KEY (drug_id) REFERENCES public.drugs(id);


--
-- Name: external_consultant fk59mvaoao3hqeefitoq3tnrcq0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_consultant
    ADD CONSTRAINT fk59mvaoao3hqeefitoq3tnrcq0 FOREIGN KEY (consultancy_firm_corporation_id) REFERENCES public.consultancy_firm(corporation_id);


--
-- Name: images fk5fd3rjs1oxd6eqpw1r7fqsf0v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT fk5fd3rjs1oxd6eqpw1r7fqsf0v FOREIGN KEY (storage_id) REFERENCES public.image_storage(id);


--
-- Name: image_storage fk5lgjtiiygv4mq2ttjh9cufaj5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_storage
    ADD CONSTRAINT fk5lgjtiiygv4mq2ttjh9cufaj5 FOREIGN KEY (corporation_id) REFERENCES public._corporation(id);


--
-- Name: quality_manager fk60g444hqbkhlpfbqb3yhqqygu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_manager
    ADD CONSTRAINT fk60g444hqbkhlpfbqb3yhqqygu FOREIGN KEY (managed_company_corporation_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: audit_checklist fk6drfn6t1vo2qh9ufqcv3qjwe3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_checklist
    ADD CONSTRAINT fk6drfn6t1vo2qh9ufqcv3qjwe3 FOREIGN KEY (storage_id) REFERENCES public.file_owner(id);


--
-- Name: quality_manager fk722e7rn95dfd3ps6rc9ujg8ox; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quality_manager
    ADD CONSTRAINT fk722e7rn95dfd3ps6rc9ujg8ox FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: consultancy_firm fk7lw04t082ec7nmi6mobaymg98; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultancy_firm
    ADD CONSTRAINT fk7lw04t082ec7nmi6mobaymg98 FOREIGN KEY (corporation_id) REFERENCES public._corporation(id);


--
-- Name: treatments_parcels fk86eikx8wr8f73hj3rm26xot1r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments_parcels
    ADD CONSTRAINT fk86eikx8wr8f73hj3rm26xot1r FOREIGN KEY (treatment_id) REFERENCES public.treatments(id);


--
-- Name: external_auditor fk8m2270ylyvgj376hhax39dctt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_auditor
    ADD CONSTRAINT fk8m2270ylyvgj376hhax39dctt FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: managed_company_audit_firm fk8oyof0oich7mxxisd2eme1pwy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_audit_firm
    ADD CONSTRAINT fk8oyof0oich7mxxisd2eme1pwy FOREIGN KEY (managed_company_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: firm_analysis fk8xb2dqcgt2k148tstk47bw8l7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_analysis
    ADD CONSTRAINT fk8xb2dqcgt2k148tstk47bw8l7 FOREIGN KEY (storage_id) REFERENCES public.file_owner(id);


--
-- Name: image_storage fk9qyat5cnw887u65njgkaerhx6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_storage
    ADD CONSTRAINT fk9qyat5cnw887u65njgkaerhx6 FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: user_groups fk9xpw9tn5aa8a9dri170rw0xjr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_groups
    ADD CONSTRAINT fk9xpw9tn5aa8a9dri170rw0xjr FOREIGN KEY (group_id) REFERENCES public.principle_groups(id);


--
-- Name: audit_type fkahfaluohi42s229hi7qobujdu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_type
    ADD CONSTRAINT fkahfaluohi42s229hi7qobujdu FOREIGN KEY (audit_checklist_id) REFERENCES public.audit_checklist(id);


--
-- Name: account_manager fkatm281x63iv7dgea1khy18l93; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_manager
    ADD CONSTRAINT fkatm281x63iv7dgea1khy18l93 FOREIGN KEY (managed_company_corporation_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: audit_firm fkay0oicrrviyyfgf9tom7wuhy3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_firm
    ADD CONSTRAINT fkay0oicrrviyyfgf9tom7wuhy3 FOREIGN KEY (firm_id) REFERENCES public.firm(id);


--
-- Name: group_request fkbo7gaavnslt7nedamxpk6sjxr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_request
    ADD CONSTRAINT fkbo7gaavnslt7nedamxpk6sjxr FOREIGN KEY (group_id) REFERENCES public.principle_groups(id);


--
-- Name: _corporation fkcesnp8up3wvcdl9up0ljeth6v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._corporation
    ADD CONSTRAINT fkcesnp8up3wvcdl9up0ljeth6v FOREIGN KEY (storage_id) REFERENCES public.image_storage(id);


--
-- Name: enemy fkcq0ru4jl053wmukwrn2n7oco8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enemy
    ADD CONSTRAINT fkcq0ru4jl053wmukwrn2n7oco8 FOREIGN KEY (drug_id) REFERENCES public.drugs(id);


--
-- Name: firm_analysis fkcu1bmx938gr2mygdoqhbichin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_analysis
    ADD CONSTRAINT fkcu1bmx938gr2mygdoqhbichin FOREIGN KEY (firm_id) REFERENCES public.firm(id);


--
-- Name: firm_assignment fkeko2ytippji1brykrw7mdejqt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_assignment
    ADD CONSTRAINT fkeko2ytippji1brykrw7mdejqt FOREIGN KEY (firm_responsible_id) REFERENCES public.firm_responsible(id);


--
-- Name: parcel fkgtrsxkjsw6e2wnt3h2ru61pr7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT fkgtrsxkjsw6e2wnt3h2ru61pr7 FOREIGN KEY (culture_id) REFERENCES public.culture(id);


--
-- Name: firm fkhugbt2xftbsyp9pup6sygno6y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm
    ADD CONSTRAINT fkhugbt2xftbsyp9pup6sygno6y FOREIGN KEY (storage_id) REFERENCES public.file_owner(id);


--
-- Name: files fki1a9soolxa2khk5wq3k9v3h0b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT fki1a9soolxa2khk5wq3k9v3h0b FOREIGN KEY (file_owner_id) REFERENCES public.file_owner(id);


--
-- Name: token fkiblu4cjwvyntq3ugo31klp1c6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkiblu4cjwvyntq3ugo31klp1c6 FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: treatments_parcels fkihbp7pt0g06xnyd7v8lbk86no; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments_parcels
    ADD CONSTRAINT fkihbp7pt0g06xnyd7v8lbk86no FOREIGN KEY (parcels_id) REFERENCES public.parcel(id);


--
-- Name: parcel fkivjq1phhs5vh6vv51tkib2yqg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT fkivjq1phhs5vh6vv51tkib2yqg FOREIGN KEY (firm_id) REFERENCES public.firm(id);


--
-- Name: account_manager fkjosnvb3cwytonil8j6o2oe8hs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_manager
    ADD CONSTRAINT fkjosnvb3cwytonil8j6o2oe8hs FOREIGN KEY (quality_manager_user_id) REFERENCES public.quality_manager(user_id);


--
-- Name: group_request fkjsn18gpo4hb8josiiwlk55s3m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_request
    ADD CONSTRAINT fkjsn18gpo4hb8josiiwlk55s3m FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: treatments fkk5ttnqh51d94givjv500l3dwy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.treatments
    ADD CONSTRAINT fkk5ttnqh51d94givjv500l3dwy FOREIGN KEY (operator_id) REFERENCES public.operator(id);


--
-- Name: supervisory_board_member fkkpkruhyqh5e18kaufhacapnem; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervisory_board_member
    ADD CONSTRAINT fkkpkruhyqh5e18kaufhacapnem FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: lmr fkkvebrss63i2lsowbrseyemuwc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lmr
    ADD CONSTRAINT fkkvebrss63i2lsowbrseyemuwc FOREIGN KEY (drug_id) REFERENCES public.drugs(id);


--
-- Name: managed_company_audit_firm fkl0d5xcy8lcmso700uh90dr4o4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_audit_firm
    ADD CONSTRAINT fkl0d5xcy8lcmso700uh90dr4o4 FOREIGN KEY (audit_firm_id) REFERENCES public.auditing_firm(corporation_id);


--
-- Name: audit fkl956tasij8e4sb2wo7wkafkm0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit
    ADD CONSTRAINT fkl956tasij8e4sb2wo7wkafkm0 FOREIGN KEY (storage_id) REFERENCES public.file_owner(id);


--
-- Name: external_consultant fklgm5y85wcs01ov7wcdj2mhnb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_consultant
    ADD CONSTRAINT fklgm5y85wcs01ov7wcdj2mhnb FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: audit_firm fkmt1p7snhpadepoiyx9t6kpho7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_firm
    ADD CONSTRAINT fkmt1p7snhpadepoiyx9t6kpho7 FOREIGN KEY (audit_id) REFERENCES public.audit(id);


--
-- Name: parcel fkn6s40g6x2t2a6ua5b8mcqdshq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT fkn6s40g6x2t2a6ua5b8mcqdshq FOREIGN KEY (storage_id) REFERENCES public.file_owner(id);


--
-- Name: managed_company_consultancy_firm fknrvy6cqq3dge6b4bto6u9ne7q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_consultancy_firm
    ADD CONSTRAINT fknrvy6cqq3dge6b4bto6u9ne7q FOREIGN KEY (managed_company_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: managed_company_consultancy_firm fkoiaytswtw8jef79ojdpd079nh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company_consultancy_firm
    ADD CONSTRAINT fkoiaytswtw8jef79ojdpd079nh FOREIGN KEY (consultancy_firm_id) REFERENCES public.consultancy_firm(corporation_id);


--
-- Name: culture fkoxwdim682uoslsu33jp1kwmi2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.culture
    ADD CONSTRAINT fkoxwdim682uoslsu33jp1kwmi2 FOREIGN KEY (variety_id) REFERENCES public.variety(id);


--
-- Name: drug_active_matter fkp6u78vxfrxov0f6pgkurxku6f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drug_active_matter
    ADD CONSTRAINT fkp6u78vxfrxov0f6pgkurxku6f FOREIGN KEY (active_matter_id) REFERENCES public.active_matter(id);


--
-- Name: drug_active_matter fkplt9b5rmwg0y6n6ki9sllg40p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drug_active_matter
    ADD CONSTRAINT fkplt9b5rmwg0y6n6ki9sllg40p FOREIGN KEY (drug_id) REFERENCES public.drugs(id);


--
-- Name: audit_checklist fkpx2eu0pfswnqel23v5gc4j1tk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_checklist
    ADD CONSTRAINT fkpx2eu0pfswnqel23v5gc4j1tk FOREIGN KEY (audit_type_id) REFERENCES public.audit_type(id);


--
-- Name: supervisory_board_member fkqrph11uajo43qxqmgw7re57s3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervisory_board_member
    ADD CONSTRAINT fkqrph11uajo43qxqmgw7re57s3 FOREIGN KEY (managed_company_corporation_id) REFERENCES public.managed_company(corporation_id);


--
-- Name: external_auditor fkrbt6lvch5315yum23v4vrr67f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_auditor
    ADD CONSTRAINT fkrbt6lvch5315yum23v4vrr67f FOREIGN KEY (audit_firm_id) REFERENCES public.auditing_firm(corporation_id);


--
-- Name: _user fkrjxe6bqrjen76odmib5jkx02d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT fkrjxe6bqrjen76odmib5jkx02d FOREIGN KEY (storage_id) REFERENCES public.image_storage(id);


--
-- Name: user_groups fkskk0ubmt29ldujvpbi49sjwrx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_groups
    ADD CONSTRAINT fkskk0ubmt29ldujvpbi49sjwrx FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- Name: managed_company fksmt967qb6syywjrh02qv2g9o5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managed_company
    ADD CONSTRAINT fksmt967qb6syywjrh02qv2g9o5 FOREIGN KEY (corporation_id) REFERENCES public._corporation(id);


--
-- Name: firm_assignment fkt36p33k1cb74jb7k8gjcmc1j5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firm_assignment
    ADD CONSTRAINT fkt36p33k1cb74jb7k8gjcmc1j5 FOREIGN KEY (firm_id) REFERENCES public.firm(id);


--
-- PostgreSQL database dump complete
--

