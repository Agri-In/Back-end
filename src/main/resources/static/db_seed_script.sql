-- Insert into principle_groups
INSERT INTO principle_groups (id, code, group_name, created_at)
VALUES
    ('3b241101-e2bb-4255-8caf-4136c566a990', 'DU', 'DEFAULT_USER', now()),
('3b241101-e2bb-4255-8caf-4146c566a990', 'ADM', 'ADMIN', now()),
('3b241101-e2bb-4255-8caf-4136c569a990', 'QM', 'QUALITY_MANAGER', now()),
('3b241101-e2bb-4255-8caf-4136c596a990', 'AM', 'ACCOUNT_MANAGER', now());

INSERT INTO file_owner(id, created_at)
VALUES ('3b441101-e2bb-4255-8caf-4146c566a990', now()),
       ('3b441101-e2cb-4255-8caf-4146c566a990', now());

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-4255-8caf-4136c566a984', now()),
    ('3b241101-e2bb-4255-8caf-4136c566a985', now());

INSERT INTO _corporation(id, created_at, building, city, district, postal_code, region, street, email, foundation_date, legal_name, phone_number, size, storage_id)
VALUES ('3b241101-e2bb-4355-8caf-9136c566a966', now(), 216, 'CASABLANCA', 'LILA', 987666, 'CB', '233', 'email@email.com', now(), 'AGRO VISION', 98766655733, 'LARGE', '3b241101-e2bb-4255-8caf-4136c566a984'),
('3b241101-e2cb-4255-8caf-9136c566a966', now(), 987, 'CASABLANCA', 'LILA', 987666, 'CB','289', 'nouhi@email.com', now(), 'NOUHI HOLDING', 98766655433, 'LARGE', '3b241101-e2bb-4255-8caf-4136c566a985');

UPDATE image_storage SET corporation_id = '3b241101-e2bb-4355-8caf-9136c566a966' WHERE id = '3b241101-e2bb-4255-8caf-4136c566a984';
UPDATE image_storage SET corporation_id = '3b241101-e2cb-4255-8caf-9136c566a966' WHERE id = '3b241101-e2bb-4255-8caf-4136c566a985';


-- Insert into managed_company
INSERT INTO managed_company (corporation_id)
VALUES ('3b241101-e2bb-4355-8caf-9136c566a966'),
       ('3b241101-e2cb-4255-8caf-9136c566a966');

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-4295-8caf-4136c566a984', now());
-- Insert into _user
INSERT INTO _user (id, password, storage_id, phone_number, email, firstname, lastname, gender, nationality, status,
                   birth_date, identity_document_type, identity_document_number, enabled, failed_login_attempts,
                   login_disabled, account_non_locked, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a966', 'password', '3b241101-e2bb-4295-8caf-4136c566a984', '0123456789',
        'email1@example.com', 'John', 'Doe', 'MALE', 'US', 'OFFLINE', '2000-01-01', 'PASSPORT', '123456789', true, 0,
        false, true, now());

UPDATE image_storage SET user_id = '3b241101-e2bb-4255-8caf-4136c566a966' WHERE id = '3b241101-e2bb-4295-8caf-4136c566a984';


-- Insert into user_groups
INSERT INTO user_groups (user_id, group_id)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a966', '3b241101-e2bb-4255-8caf-4136c566a990');

-- Insert into token
INSERT INTO token (id, token, token_type, revoked, expired, user_id, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a994', 'token1', 'BEARER', false, false,
        '3b241101-e2bb-4255-8caf-4136c566a966', now());

-- Insert into Address
-- INSERT INTO Address (region, district, city, street, building, postal_code, user_id)
-- VALUES ('Region 1', 'District 1', 'City 1', 'Street 1', 1, 1001, '3b241101-e2bb-4255-8caf-4136c566a966');

INSERT INTO file_owner (id, created_at)
VALUES
    ('3b241101-e2bb-4295-8caf-4136c266a984', now());
-- Insert into Firm
INSERT INTO Firm (id, firm_name, firm_surface_hectare, region, district, city, street, building, postal_code, storage_id, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a966', 'Firm 1', 100.0,'Region 1', 'District 1', 'City 1', 'Street 1', 1, 1001, '3b241101-e2bb-4295-8caf-4136c266a984', now());



-- Insert into group_requests
-- INSERT INTO group_requests (id, group_id)
-- VALUES ('3b241101-e2bb-4255-8caf-4136c566a992', '3b241101-e2bb-4255-8caf-4136c566a990');

-- Insert into group_request
INSERT INTO group_request (id, user_id, group_id, status, created_at)
VALUES ('3b241101-e2fb-4255-8caf-4136c566a992', '3b241101-e2bb-4255-8caf-4136c566a966',
        '3b241101-e2bb-4255-8caf-4136c569a990', 'PENDING', now());

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-6255-8caf-4136c566a984', now());

INSERT INTO _corporation(id, created_at, building, city, district, postal_code, region, street, email, foundation_date, legal_name, phone_number, size, storage_id)
VALUES ('3b241101-e5bb-4355-8caf-9136c566a966', now(), 216, 'CASABLANCA', 'LILA', 987666, 'CB', '233', 'Deloitte@email.com', now(), 'Deloitte', 98766755733, 'LARGE', '3b241101-e2bb-6255-8caf-4136c566a984');

UPDATE image_storage SET corporation_id = '3b241101-e5bb-4355-8caf-9136c566a966' WHERE id = '3b241101-e2bb-6255-8caf-4136c566a984';
-- Insert into audit_firm
INSERT INTO auditing_firm (corporation_id)
VALUES ('3b241101-e5bb-4355-8caf-9136c566a966');

INSERT INTO _user (id, password, storage_id, phone_number, email, firstname, lastname, gender, nationality, status,
                   birth_date, identity_document_type, identity_document_number, enabled, failed_login_attempts,
                   login_disabled, account_non_locked, created_at)
VALUES ('3b241101-e2bb-4275-8caf-4136c566a966', 'password', '3b241101-e2bb-6255-8caf-4136c566a984', '0123256789',
        'auditor@example.com', 'Auditor', 'au', 'MALE', 'US', 'OFFLINE', '1980-01-01', 'PASSPORT', 'JX451089', true, 0,
        false, true, now());
-- Insert into external_auditor
INSERT INTO external_auditor (user_id, audit_firm_id)
VALUES ('3b241101-e2bb-4275-8caf-4136c566a966', '3b241101-e5bb-4355-8caf-9136c566a966');


INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-6255-8caf-4136c566b984', now());

INSERT INTO _corporation(id, created_at, building, city, district, postal_code, region, street, email, foundation_date, legal_name, phone_number, size, storage_id)
VALUES ('3b241101-e5bb-4355-8caf-9136c576a966', now(), 216, 'CASABLANCA', 'LILA', 987666, 'CB', '233', 'pwc@email.com', now(), 'PwC', 98766755133, 'LARGE', '3b241101-e2bb-6255-8caf-4136c566b984');

UPDATE image_storage SET corporation_id = '3b241101-e5bb-4355-8caf-9136c576a966' WHERE id = '3b241101-e2bb-6255-8caf-4136c566b984';

-- Insert into consultancy_firm
INSERT INTO consultancy_firm (corporation_id)
VALUES ('3b241101-e5bb-4355-8caf-9136c576a966');

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-6155-8caf-4136c566a984', now());

INSERT INTO _user (id, password, storage_id, phone_number, email, firstname, lastname, gender, nationality, status,
                   birth_date, identity_document_type, identity_document_number, enabled, failed_login_attempts,
                   login_disabled, account_non_locked, created_at)
VALUES ('3b241101-e2bb-1275-8caf-4136c566a966', 'password', '3b241101-e2bb-6155-8caf-4136c566a984', '0123236789',
        'externalConsultant@example.com', 'External Consultant', 'au', 'MALE', 'US', 'OFFLINE', '1980-01-01', 'PASSPORT', 'JX451099', true, 0,
        false, true, now());
-- Insert into external_consultant
INSERT INTO external_consultant (user_id, consultancy_firm_corporation_id)
VALUES ('3b241101-e2bb-1275-8caf-4136c566a966', '3b241101-e5bb-4355-8caf-9136c576a966');

-- Insert into firm_responsible
INSERT INTO firm_responsible (id, firstname, lastname, gender, nationality, phone_number, managed_company_corporation_id, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a980', 'Responsable', 'Ferme', 'MALE', 'US', '0125456789',
        '3b241101-e2bb-4355-8caf-9136c566a966', now());

INSERT INTO file_owner (id, created_at)
VALUES
    ('3b241101-e2bb-4295-8caf-2206c266a984', now()),
    ('3b241101-e2bb-4295-8caf-2206c300a984', now()),
    ('3b241202-e2bb-4295-8caf-2206c300a984', now()),
    ('3b241202-e2bb-4295-8caf-2206c300a204', now());

INSERT INTO audit_checklist(id, created_at, checklist_name, storage_id)
VALUES('6c341101-e2bb-4295-8caf-2206c266a984', now(), 'Checklist social', '3b241101-e2bb-4295-8caf-2206c300a984'),
      ('6c341101-e2bb-4295-8caf-2306c266a984', now(), 'Checklist drouge', '3b241202-e2bb-4295-8caf-2206c300a984'),
      ('6c341201-e2bb-4295-8caf-2306c266a984', now(), 'Checklist qualité', '3b241202-e2bb-4295-8caf-2206c300a204');
-- Insert into audit_type
INSERT INTO audit_type (id, audit_type_name, audit_type_description, audit_checklist_id, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a972', 'SMETA', 'Description',
        '6c341101-e2bb-4295-8caf-2206c266a984', now()),
       ('3b241101-e2bb-4255-8caf-4136c566a172', 'Qualité', 'Description',
        '6c341201-e2bb-4295-8caf-2306c266a984', now());

-- Insert into audit
INSERT INTO audit (id, date, audit_type_id, storage_id, status, created_at)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a964', '2022-01-01 00:00:00', '3b241101-e2bb-4255-8caf-4136c566a972', '3b241101-e2bb-4295-8caf-2206c266a984', 'PENDING', now());
-- Insert into audit firm joint table
INSERT INTO audit_firm (audit_id, firm_id)
VALUES ('3b241101-e2bb-4255-8caf-4136c566a964', '3b241101-e2bb-4255-8caf-4136c566a966');

-- Insert into managed_company_audit_firm
INSERT INTO managed_company_audit_firm (managed_company_id, audit_firm_id)
VALUES ('3b241101-e2bb-4355-8caf-9136c566a966', '3b241101-e5bb-4355-8caf-9136c566a966');

-- Insert into managed_company_consultancy_firm
INSERT INTO managed_company_consultancy_firm (managed_company_id, consultancy_firm_id)
VALUES ('3b241101-e2bb-4355-8caf-9136c566a966', '3b241101-e5bb-4355-8caf-9136c576a966');

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-4295-8caf-4706c566a984', now());
-- Insert into _user
INSERT INTO _user (id, password, storage_id, phone_number, email, firstname, lastname, gender, nationality, status,
                   birth_date, identity_document_type, identity_document_number, enabled, failed_login_attempts,
                   login_disabled, account_non_locked, created_at)
VALUES ('3b241101-e2bb-4255-4caf-4136c566a966', 'password', '3b241101-e2bb-4295-8caf-4706c566a984', '06875436543',
        'soumaya.nouhi@gmail.com', 'SOUMAYA', 'NOUHI', 'FEMALE', 'US', 'OFFLINE', '1998-01-01', 'CIN', 'JY987645', true, 0,
        false, true, now());

UPDATE image_storage SET user_id = '3b241101-e2bb-4255-4caf-4136c566a966' WHERE id = '3b241101-e2bb-4295-8caf-4706c566a984';

-- Insert into quality_manager
INSERT INTO quality_manager (user_id, managed_company_corporation_id)
VALUES ('3b241101-e2bb-4255-4caf-4136c566a966', '3b241101-e2bb-4355-8caf-9136c566a966');

INSERT INTO image_storage (id, created_at)
VALUES
    ('3b241101-e2bb-4295-8caf-4706c066a984', now());
-- Insert into _user
INSERT INTO _user (id, password, storage_id, phone_number, email, firstname, lastname, gender, nationality, status,
                   birth_date, identity_document_type, identity_document_number, enabled, failed_login_attempts,
                   login_disabled, account_non_locked, created_at)
VALUES ('3b241101-e2ab-4255-4caf-4136c566a966', 'password', '3b241101-e2bb-4295-8caf-4706c066a984', '06825436543',
        'sidati.nouhi@gmail.com', 'Sidati', 'NOUHI', 'MALE', 'US', 'OFFLINE', '1998-01-01', 'CIN', 'JY980645', true, 0,
        false, true, now());

UPDATE image_storage SET user_id = '3b241101-e2ab-4255-4caf-4136c566a966' WHERE id = '3b241101-e2bb-4295-8caf-4706c066a984';

-- Insert into supervisory_board_member
INSERT INTO supervisory_board_member (user_id, managed_company_corporation_id)
VALUES ('3b241101-e2ab-4255-4caf-4136c566a966', '3b241101-e2bb-4355-8caf-9136c566a966');