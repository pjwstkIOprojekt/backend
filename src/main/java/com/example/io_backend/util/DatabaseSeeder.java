package com.example.io_backend.util;

import com.example.io_backend.model.*;
import com.example.io_backend.model.enums.*;
import com.example.io_backend.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Host;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {
    private final UserRepository userRepository;
    private final MedicalInfoRepository medicalInfoRepository;
    private final StaffRepository staffRepository;
    private final VictimRepository victimRepository;
    private final AmbulanceRepository ambulanceRepository;
    private final TutorialRepository tutorialRepository;
    private final ReviewRepository reviewRepository;
    private final EquipmentRepository equipmentRepository;
    private final FacilityRepository facilityRepository;

    private final PasswordEncoder passwordEncoder;

    private final int entitiesToGenerate = 10;

    @Override
    public void run(ApplicationArguments args) {
       medicalInfoRepository.saveAll(generateMedicalInfos(entitiesToGenerate));
       userRepository.saveAll(generateUsers(entitiesToGenerate));
       staffRepository.saveAll(generateStaff(entitiesToGenerate));
       victimRepository.saveAll(generateVictims(entitiesToGenerate));
       ambulanceRepository.saveAll(generateAmbulances(entitiesToGenerate));
       tutorialRepository.saveAll(generateTutorials(entitiesToGenerate));
       reviewRepository.saveAll(generateReviews(entitiesToGenerate));
       equipmentRepository.saveAll(generateEquipment(entitiesToGenerate));
       facilityRepository.saveAll(generateFacilities(entitiesToGenerate));

    }

    private List<MedicalInfo> generateMedicalInfos(int length) {
        List<MedicalInfo> medicalInfos = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            MedicalInfo medicalInfo = new MedicalInfo();
            medicalInfo.setAllergies(allergies.get(ThreadLocalRandom.current().nextInt(allergies.size())));
            medicalInfo.setBloodType(EnumUtils.randomValue(BloodType.class));
            medicalInfo.setChronicDiseases(chronicDiseases.get(ThreadLocalRandom.current().nextInt(chronicDiseases.size())));
            medicalInfo.setId(null);

            medicalInfos.add(medicalInfo);
        }

        return medicalInfos;
    }

    private List<User> generateUsers(int length) {
        List<User> users = new ArrayList<>();
        List<MedicalInfo> medicalInfos = medicalInfoRepository.findAll();

        for (int i = 0; i < length; i++) {
            User user = new User();
            user.setId(null);
            user.setBirthDate(new Date(ThreadLocalRandom.current().nextInt() * 1000L));
            user.setEmail(emails.get(ThreadLocalRandom.current().nextInt(emails.size())));
            user.setPassword(passwordEncoder.encode("passwordsalt"));
            user.setSalt("salt");
            user.setBandCode(UUID.randomUUID().toString());
            user.setFirstName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[0]);
            user.setLastName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[1]);
            user.setMedicalInfo(medicalInfos.get(ThreadLocalRandom.current().nextInt(medicalInfos.size())));
            user.setPhone(String.format("%09d", ThreadLocalRandom.current().nextInt(1000000000)));

            users.add(user);
        }

        return users;
    }

    private List<Staff> generateStaff(int length) {
        List<Staff> staffList = new ArrayList<>();

        boolean ok = false;

        for (int i = 0; i < length; i++) {
            Staff staff = new Staff();
            staff.setId(null);
            staff.setStaffType(EnumUtils.randomValue(StaffType.class));
            staff.setFirstName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[0]);
            staff.setLastName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[1]);

            while (!ok) {
                try {
                    staff.setMail(emails.get(ThreadLocalRandom.current().nextInt(emails.size())));
                    ok = true;
                } catch (ConstraintViolationException ignored) {}
            }

            staff.setSalt("salt");
            staff.setPasswordHash(passwordEncoder.encode("passwordsalt"));

            staffList.add(staff);
        }

        return staffList;
    }

    private List<Victim> generateVictims(int length) {
        List<Victim> victims = new ArrayList<>();
        List<MedicalInfo> medicalInfos = medicalInfoRepository.findAll();

        for (int i = 0; i < length; i++) {
            Victim victim = new Victim();
            victim.setId(null);
            victim.setFirstName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[0]);
            victim.setLastName(names.get(ThreadLocalRandom.current().nextInt(names.size())).split(" ")[1]);
            victim.setMedicalInfo(medicalInfos.get(ThreadLocalRandom.current().nextInt(medicalInfos.size())));
            victim.setDocumentId(UUID.randomUUID().toString());
            victim.setDocumentName(documentNames.get(ThreadLocalRandom.current().nextInt(documentNames.size())));

            victims.add(victim);
        }

        return victims;
    }

    private List<Ambulance> generateAmbulances(int length) {
        List<Ambulance> ambulances = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Ambulance ambulance = new Ambulance();
            ambulance.setAmbulanceKind(EnumUtils.randomValue(AmbulanceKind.class));
            ambulance.setAmbulanceType(EnumUtils.randomValue(AmbulanceType.class));
            ambulance.setId(null);
            ambulance.setPeopleCapacity(5);
            ambulance.setPlates(numberPlates.get(ThreadLocalRandom.current().nextInt(numberPlates.size())));
            ambulance.setFuelCapacity(400000);

            ambulances.add(ambulance);
        }

        return ambulances;
    }

    private List<Tutorial> generateTutorials(int length) {
        List<Tutorial> tutorials = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Tutorial tutorial = new Tutorial();
            tutorial.setTutorialKind(EnumUtils.randomValue(TutorialKind.class));
            tutorial.setId(null);
            tutorial.setAverage(Double.valueOf(String.format(Locale.ROOT,"%.2f", Math.random())));
            tutorial.setName("Tutorial " + i);

            tutorials.add(tutorial);
        }

        return tutorials;
    }

    private List<Review> generateReviews(int length) {
        List<Review> reviews = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Review review = new Review();
            review.setContent("lorem ipsum");
            review.setId(null);
            review.setRating(ThreadLocalRandom.current().nextInt(1,11));

            reviews.add(review);
        }

        return reviews;
    }

    private List<Equipment> generateEquipment(int length) {
        List<Equipment> equipments = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Equipment eq = new Equipment();
            eq.setId(null);
            eq.setName("EQ" + i);

            equipments.add(eq);
        }

        return equipments;
    }

    private List<Facility> generateFacilities(int length) {
        List<Facility> facilities = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Facility f = new Facility();
            f.setId(null);
            f.setName("Facility " + i);
            f.setFacilityType(EnumUtils.randomValue(FacilityType.class));
            f.setHospitalType(EnumUtils.randomValue(HospitalType.class));
            f.setMaximumBeds(ThreadLocalRandom.current().nextInt(10, 101));
            f.setSet(null); // ???

            facilities.add(f);
        }

        return facilities;
    }

    private final List<String> chronicDiseases = List.of(
            "ASTMA",
            "CUKRZYCA",
            "NADCIŚNIENIE"
    );

    private final List<String> allergies = List.of(
            "ORZECHY",
            "PYŁKI",
            "TRUSKAWKI",
            "ROZTOCZA"
    );

    private final List<String> emails = List.of(
            "bockelboy@sbcglobal.net",
            "ubergeeb@att.net",
            "webteam@msn.com",
            "hermes@outlook.com",
            "themer@hotmail.com",
            "oster@yahoo.com",
            "lbecchi@msn.com",
            "koudas@mac.com",
            "mstrout@yahoo.ca",
            "liedra@yahoo.com",
            "email@example.com",
            "test@test.com",
            "abcdef@gmail.com"
    );

    private final List<String> names = List.of(
            "Pamela Rikki",
            "Wilburn Jolene",
            "Addie Peter",
            "Alex Geneva",
            "Odetta Leon",
            "Pamela Rikki",
            "Wilburn Jolene",
            "Addie Peter",
            "Odetta Leon",
            "Isabella Brielle",
            "Gardenia Matt",
            "Camilla Vince",
            "Ness Petronel",
            "Jacob Neely"
    );

    private final List<String> documentNames = List.of(
            "DOKUMENT1",
            "DOKUMENT2",
            "DOKUMENT3",
            "DOKUMENT4",
            "DOKUMENT5",
            "DOKUMENT6"
    );

    private final List<String> numberPlates = List.of(
            "KWA4862",
            "ZKA0443",
            "RST5405",
            "TKI8453",
            "BKL5392",
            "WPZ8939",
            "WSK4065",
            "TLW7107",
            "WM71020",
            "GA47053",
            "OOL6118",
            "TKN1306",
            "WLS8512"
    );

}
