
package net.mcreator.zipmod.item;

import org.omg.CORBA.ObjectHolder;

import net.mcreator.zipmod.ZipmodModElements;

@ZipmodModElements.ModElement.Tag
public class FiryteArmorArmorItem extends ZipmodModElements.ModElement {
	@ObjectHolder("zipmod:firyte_armor_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("zipmod:firyte_armor_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("zipmod:firyte_armor_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("zipmod:firyte_armor_armor_boots")
	public static final Item boots = null;
	public FiryteArmorArmorItem(ZipmodModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 150;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{20, 60, 50, 20}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 90;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "firyte_armor_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zipmod:textures/models/armor/firytearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("firyte_armor_armor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zipmod:textures/models/armor/firytearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("firyte_armor_armor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zipmod:textures/models/armor/firytearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("firyte_armor_armor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zipmod:textures/models/armor/firytearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("firyte_armor_armor_boots"));
	}
}
