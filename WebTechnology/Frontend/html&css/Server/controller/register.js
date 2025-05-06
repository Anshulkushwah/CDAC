const register = require("../model/register")
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

const registration = async(req,res) => {
    try{
        const {name, email, designation, password} = req.body

    if( !name || !email || !designation || !password){
        return res.status(400).json({
            success : false,
            message : "Please Fill all the details"
        })
    }

    const existingUser = await register.findOne({ email });

    if (existingUser) {
      return res.status(409).json({
        success: false,
        message: "User already exists with this email",
      });
    }
    
    const haspass = await bcrypt.hash(password, 10);

    const newUser = await register.create({name, email, designation, password : haspass});

    // Respond with success
    res.status(201).json({
        success: true,
        message: "User registered successfully",
        user: {
          name: newUser.name,
          email: newUser.email,
          designation: newUser.designation,
          createdAt: newUser.createdAt,
        },
      });

    }catch(err){
        console.error("Error in registration:", err.message);
        res.status(500).json({
          success: false,
          message: "Internal server error",
        });
    }
}

const login = async (req, res) => {
  try {
    const { email, password } = req.body;

    if (!email || !password) {
      return res.status(400).json({
        success: false,
        message: "Please provide both email and password",
      });
    }

    const user = await register.findOne({ email });
    if (!user) {
      return res.status(401).json({
        success: false,
        message: "Invalid email or password",
      });
    }

    const isMatch = await bcrypt.compare(password, user.password);
    if (!isMatch) {
      return res.status(401).json({
        success: false,
        message: "Invalid email or password",
      });
    }

    const token = jwt.sign(
      { userId: user._id, email: user.email },
      process.env.JWT_SECRET,
      { expiresIn: "1h" }
    );

    // Set token in response header
    res.setHeader("token", token);

    res.status(200).json({
      success: true,
      message: "Login successful",
      token,
      user: {
        name: user.name,
        email: user.email,
        designation: user.designation,
      },
    });
  } catch (err) {
    console.error("Login error:", err.message);
    res.status(500).json({
      success: false,
      message: "Internal server error",
    });
  }
};

const accountDelete = async(req,res) => {

 try{

  const {email} = req.body;

  if(!email){
    return res.status(400).json({
      status: false,
      message : "Enter mail id",
    })
  }

  const userid = await register.findOne({email});

  if(!userid){
    return res.status(400).json({
      status: false,
      message : "No user found with this email",
    })
  }

  await register.deleteOne({email});

  res.status(200).json({
    success : true,
    message : `User with email ${email} deleted successfully`
  })

 }catch(err){
  console.error("Error deleting account:", err.message);
  res.status(500).json({
    success: false,
    message: "Internal server error",
  });
 }
}

  const updatePassword = async (req, res) => {
    try {
      const { oldPassword, newPassword } = req.body;
  
    const userId = req.user?.userId; // ✅ From token middleware
      if (!userId) {
        return res.status(401).json({
          success: false,
          message: "Unauthorized. Token missing or invalid.",
        });
      }

      if (!oldPassword || !newPassword) {
        return res.status(400).json({
          success: false,
          message: "Please provide both old and new passwords",
        });
      }

      const user = await register.findById(userId);
      if (!user) {
        return res.status(404).json({
          success: false,
          message: "User not found",
        });
      }

      // Ensure user.password is treated as a string
      const storedHashedPassword = String(user.password);

      const isMatch = await bcrypt.compare(oldPassword, storedHashedPassword);
      if (!isMatch) {
        return res.status(401).json({
          success: false,
          message: "Old password is incorrect",
        });
      }

      const hashedNewPassword = await bcrypt.hash(newPassword, 10);
      user.password = hashedNewPassword.toString();
      await user.save();

      res.status(200).json({
        success: true,
        message: "Password updated successfully",
      });
    } catch (err) {
      console.error("Password update error:", err.message);
      res.status(500).json({
        success: false,
        message: "Internal server error",
      });
    }
  };

module.exports = {
    registration,
    login,
    accountDelete,
    updatePassword,
  };

