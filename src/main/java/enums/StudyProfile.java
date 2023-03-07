package enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    MACKDONALDSTAFF("Филология"), // =)
    ONEMOREMACKDONALDSTAFF("Экономика"),
    PSYCHOLOGY("Психология"),
    PHYSICS("Физика"),
    CHEMISTRY("Химия"),
    AWESOMEGUYS("Программирование"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    LINGUISTICS("Лингвистика"),
    NONEVALUE("Не указано направление"),
    UNKNOWN("Профиль, не известный системе");
    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName=profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
